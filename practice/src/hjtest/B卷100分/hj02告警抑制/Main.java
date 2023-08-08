package hjtest.B卷100分.hj02告警抑制;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 100%通过
 * 注意：抑制的对象可能存在多个，
 * 先把出现的字符放进HashMap里面去重
 * A B
 * A B B B B B C
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int count = Integer.parseInt(input.nextLine());
            List<String> commandList = listCommand(count,input);
            String[] idList = buildIds(input.nextLine());
            int[] idIndex = new int[idList.length];
            HashSet<String> elements = buildMap(idList);
            for (String command : commandList) {
                String[] ids = command.split(" ");
                String id01 = ids[0];
                String id02 = ids[1];
                if (id01.equals(id02)) {
                    continue;
                }
                if (elements.contains(id01) && elements.contains(id02)) {
                    setIdIndex(id02,idList,idIndex);
                }
            }
            List<String> result = new ArrayList<>();
            for (int i = 0; i < idList.length; i++) {
                if (idIndex[i] == 1) {
                    continue;
                }
                result.add(idList[i]);
            }
            String collect = String.join(" ", result);
            System.out.println(collect);
        }
    }

    private static void setIdIndex(String hideStr, String[] idList, int[] idIndex) {
        for (int i = 0; i < idList.length; i++) {
            if (hideStr.equals(idList[i])) {
                idIndex[i] = 1;
            }
        }
    }

    private static String[] buildIds(String nextLine) {
        return nextLine.split(" ");
    }

    private static HashSet<String> buildMap(String[] ids) {
        return Arrays.stream(ids).collect(Collectors.toCollection(HashSet::new));
    }

    private static List<String> listCommand(int count, Scanner input) {
        List<String> listCommand = new ArrayList<>();
        while (count > 0) {
            listCommand.add(input.nextLine());
            count--;
        }
        return listCommand;
    }
}
