package hjtest.B卷100分.hj09文件目录大小;

import java.util.*;

/**
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] countStartInts = getInts(input.nextLine());
            int count = countStartInts[0];
            int start = countStartInts[1];
            List<String> listCommand = listCommand(count, input);
            Map<Integer, MyFile> fileIndex = buildFileIndex(listCommand);
            int size = getSize(start, fileIndex);
            System.out.println(size);
        }
        input.close();
    }

    private static int getSize(int id, Map<Integer, MyFile> fileIndex) {
        if (!fileIndex.containsKey(id)) {
            return 0;
        }
        MyFile file = fileIndex.get(id);
        int sum = file.size;
        if (file.child.isEmpty()) {
            return sum;
        }
        for (Integer child : file.child) {
            sum += getSize(child,fileIndex);
        }
        return sum;
    }

    private static Map<Integer, MyFile> buildFileIndex(List<String> listCommand) {
        Map<Integer,MyFile> map = new HashMap<>();
        for (String command : listCommand) {
            String[] splits = command.split(" ");
            int id = Integer.parseInt(splits[0]);
            int size = Integer.parseInt(splits[1]);
            MyFile file = new MyFile(id,size);
            map.put(id,file);
            String substring = splits[2].substring(1, splits[2].length() - 1);
            String[] childStrList = substring.split(",");
            for (String childStr : childStrList) {
                if (childStr.isEmpty()) {
                    continue;
                }
                int child = Integer.parseInt(childStr);
                file.addChild(child);
            }
        }
        return map;
    }

    private static List<String> listCommand(int count, Scanner input) {
        List<String> listCommand = new ArrayList<>();
        while (count > 0) {
            listCommand.add(input.nextLine());
            count--;
        }
        return listCommand;
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static class MyFile {
        private final int id;
        private final int size;
        private List<Integer> child = new ArrayList<>();

        public MyFile(int id, int size) {
            this.id = id;
            this.size = size;
        }

        public void addChild(int index) {
            child.add(index);
        }
    }
}
