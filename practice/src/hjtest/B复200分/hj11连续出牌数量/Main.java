package hjtest.B复200分.hj11连续出牌数量;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int result;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            result = Integer.MIN_VALUE;
            int[] ints = getInts(input.nextLine());
            char[] colors = getChars(input.nextLine());
            int len = ints.length;
            boolean[] used = new boolean[len];
            for (int i = 0; i < len; i++) {
                used[i] = true;
                backtracking(i,0,used,ints,colors);
                used[i] = false;
            }
            System.out.println(result);
        }
        input.close();
    }

    private static void backtracking(int index, int cur, boolean[] used, int[] ints, char[] colors) {
        cur++;
        result = Math.max(cur,result);
        int sameNumberIndex = findSameNumberIndex(index,used,ints);
        if (sameNumberIndex != -1) {
            used[sameNumberIndex] = true;
            backtracking(sameNumberIndex,cur,used,ints,colors);
            used[sameNumberIndex] = false;
        }
        int sameColorIndex = findSameColor(index,used,colors);
        if (sameColorIndex != -1) {
            used[sameColorIndex] = true;
            backtracking(sameColorIndex,cur,used,ints,colors);
            used[sameColorIndex] = false;
        }
    }

    private static int findSameColor(int index, boolean[] used, char[] colors) {
        for (int i = 0; i < colors.length; i++) {
            if (used[i]) {
                continue;
            }
            if (colors[index] == colors[i]) {
                return i;
            }
        }
        return -1;
    }

    private static int findSameNumberIndex(int index, boolean[] used, int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            if (used[i]) {
                continue;
            }
            if (ints[index] == ints[i]) {
                return i;
            }
        }
        return -1;
    }

    private static char[] getChars(String nextLine) {
        return nextLine.replaceAll(" ","").toCharArray();
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
