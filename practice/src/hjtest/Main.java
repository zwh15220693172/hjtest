package hjtest;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] splits = input.nextLine().split(" ");
        char[] targetChars = splits[0].toCharArray();
        int[] target = getTarget(targetChars);
        char[] source = splits[1].toCharArray();
        int count = 0;
        int result = -1;
        int index = 0;
        while (index < source.length) {
            char cur = source[index];
            if (target[cur] > 0) {
                target[cur]--;
                count++;
                if (count == targetChars.length) {
                    result = index - count + 1;
                    break;
                }
                index++;
            } else {
                if (count > 0) {
                    index = index - count + 1;
                    count = 0;
                    target = getTarget(targetChars);
                } else {
                    index++;
                }
            }
        }
        System.out.println(result);
        input.close();
    }

    private static int[] getTarget(char[] targetChars) {
        int[] charCount = new int[128];
        for (char cur : targetChars) {
            charCount[cur]++;
        }
        return charCount;
    }
}
