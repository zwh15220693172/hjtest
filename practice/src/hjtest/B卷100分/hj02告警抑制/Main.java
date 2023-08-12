package hjtest.B卷100分.hj02告警抑制;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 100%通过
 * 注意：抑制的对象可能存在多个，
 * 1.先把出现的字符放进HashMap里面去重
 * 2.对应的字符串的数组为String[],我们标注一个int[]与他长度相同，用来标记哪个不用
 * 3.如果为1表示弃用
 * 4.A B 如果hashMap里面存在A也存在B，那么将B的对应字符串的int[]数组标记为1，注意有可能有多个
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
