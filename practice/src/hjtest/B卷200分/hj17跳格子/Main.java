package hjtest.B卷200分.hj17跳格子;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 100%通过，打家劫舍2
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] ints = getInts(input.nextLine());
            if (ints.length == 1) {
                System.out.println(ints[0]);
            } else if (ints.length == 2) {
                System.out.println(Math.max(ints[0], ints[1]));
            } else if (ints.length == 3) {
                System.out.println(Math.max(Math.max(ints[0], ints[1]),ints[2]));
            } else {
                int max01 = getMaxFromDp(cutArray(0, ints.length - 1, ints));
                int max02 = getMaxFromDp(cutArray(1,ints.length,ints));
                System.out.println(Math.max(max01,max02));
            }
        }
        input.close();
    }

    private static int getMaxFromDp(int[] ints) {
        int[] dp = new int[ints.length];
        dp[0] = ints[0];
        dp[1] = Math.max(ints[0], ints[1]);
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i-2]+ints[i],dp[i-1]);
        }
        return dp[dp.length-1];
    }

    private static int[] cutArray(int start, int end, int[] base) {
        int[] newArray = new int[end-start];
        int index = 0;
        for (int i = start; i < end; i++) {
            newArray[index++] = base[i];
        }
        return newArray;
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
