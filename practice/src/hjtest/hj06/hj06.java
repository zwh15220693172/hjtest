package hjtest.hj06;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class hj06 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String headAndCountStr = input.nextLine();
            String curStr = getHead(headAndCountStr);
            int count = getCount(headAndCountStr);
            Map<String, StrNode> map = getIndexMap(count, input);
            int index = count / 2 + 1;
            StrNode target = null;
            while (index > 0) {
                target = map.get(curStr);
                curStr = target.next;
                index--;
            }
            if (Objects.isNull(target)) {
                System.out.println(-1);
            } else {
                System.out.println(target.val);
            }
        }
        input.close();
    }

    private static Map<String, StrNode> getIndexMap(int count, Scanner input) {
        Map<String, StrNode> map = new HashMap<>();
        while (count > 0) {
            String line = input.nextLine();
            String[] splits = line.split(" ");
            StrNode strNode = new StrNode();
            strNode.cur = splits[0];
            strNode.val = Integer.parseInt(splits[1]);
            strNode.next = splits[2];
            map.put(strNode.cur, strNode);
            count--;
        }
        return map;
    }

    private static String getHead(String headAndCountStr) {
        String[] splits = headAndCountStr.split(" ");
        return splits[0];
    }

    private static int getCount(String headAndCountStr) {
        String[] splits = headAndCountStr.split(" ");
        return Integer.parseInt(splits[1]);
    }

    private static class StrNode {
        private String cur;
        private int val;
        private String next;
    }
}
