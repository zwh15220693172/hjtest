package hjtest.B复.hj02字符串子序列2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            char[] target = input.nextLine().toCharArray();
            char first = target[0];
            char last = target[target.length-1];
            HashMap<Character,Integer> targetIndex = getTargetIndex(target);
            int[] resultIndex = new int[target.length];
            LinkedList<Integer> queue = new LinkedList<>();
            char[] source = input.nextLine().toCharArray();
            int result = -1;
            for (int i = 0; i < source.length; i++) {
                char cur = source[i];
                if (!targetIndex.containsKey(cur)) {
                    continue;
                }
                int index = targetIndex.get(cur);
                if (cur == first) {
                    queue.addLast(i);
                    resultIndex[0]++;
                } else {
                    if (resultIndex[index-1] > resultIndex[index]) {
                        resultIndex[index]++;
                        if (cur == last && !queue.isEmpty()) {
                            result = queue.poll();
                        }
                    }
                }
            }
            System.out.println(result);
        }
        input.close();
    }

    private static HashMap<Character, Integer> getTargetIndex(char[] target) {
        HashMap<Character, Integer> targetIndex = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            Character cur = target[i];
            targetIndex.put(cur,i);
        }
        return targetIndex;
    }
}
