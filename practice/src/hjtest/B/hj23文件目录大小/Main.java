package hjtest.B.hj23文件目录大小;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] countStartInts = getInts(input.nextLine());
            int count = countStartInts[0];
            int start = countStartInts[1];
            HashMap<Integer, MyFile> cursor = getCursor(count,input);
            int result = getResult(start,0,cursor);
            System.out.println(result);
        }
        input.close();
    }

    private static int getResult(int index, int sum, HashMap<Integer, MyFile> cursor) {
        if (!cursor.containsKey(index)) {
            return sum;
        }
        MyFile cur = cursor.get(index);
        sum+=cur.val;
        if (!cur.nodes.isEmpty()) {
            for (Integer next : cur.nodes) {
                sum = getResult(next, sum, cursor);
            }
        }
        return sum;
    }

    private static HashMap<Integer, MyFile> getCursor(int count, Scanner input) {
        HashMap<Integer,MyFile> map = new HashMap<>();
        while (count > 0) {
            String inputStr = input.nextLine();
            String[] strings = inputStr.split(" ");
            int index = Integer.parseInt(strings[0]);
            int val = Integer.parseInt(strings[1]);
            MyFile myFile = new MyFile(index, val);
            String substring = strings[2].substring(1, strings[2].length() - 1);
            if (!substring.isEmpty()) {
                String[] splits = substring.split(",");
                for (String split : splits) {
                    myFile.addNode(Integer.parseInt(split));
                }
            }
            map.put(index,myFile);
            count--;
        }
        return map;
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static class MyFile {
        private final int index;
        private final int val;
        private List<Integer> nodes = new ArrayList<>();

        public MyFile(int index, int val) {
            this.index = index;
            this.val = val;
        }

        public void addNode(int nodeIndex) {
            nodes.add(nodeIndex);
        }
    }
}
