package hjtest.单向链表中间节点;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            List<String> headAndCountStr = getHeadAndCountStr(input.nextLine());
            String head = headAndCountStr.get(0);
            int count = Integer.parseInt(headAndCountStr.get(1));
            HashMap<String, StrNode> indexMap = getIndexMap(count, input);
            int time = count / 2 + 1;
            int index = 0;
            StrNode targetNode = null;
            while (index < time) {
                targetNode = indexMap.get(head);
                head = targetNode.next;
                index++;
            }
            System.out.println(targetNode.val);
        }
        input.close();
    }

    private static HashMap<String, StrNode> getIndexMap(int count, Scanner input) {
        HashMap<String, StrNode> indexMap = new HashMap<>();
        while (count > 0) {
            String[] splits = input.nextLine().split(" ");
            StrNode strNode = new StrNode();
            strNode.cur = splits[0];
            strNode.val = Integer.parseInt(splits[1]);
            strNode.next = splits[2];
            indexMap.put(strNode.cur, strNode);
            count--;
        }
        return indexMap;
    }

    private static List<String> getHeadAndCountStr(String nextLine) {
        return Arrays.stream(nextLine.split(" ")).collect(Collectors.toList());
    }

    private static class StrNode {
        private String cur;
        private int val;
        private String next;
    }
}
