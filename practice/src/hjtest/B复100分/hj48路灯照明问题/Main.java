package hjtest.B复100分.hj48路灯照明问题;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextInt()) {
            int len = input.nextInt();
            int[] dp = buildDp(len,input);
            int[][] ints = buildInts(dp);
            int end = (len - 1) * 100;
            int sum = 0;
            int right = ints[0][1];
            for (int i = 1; i < ints.length; i++) {
                int[] cur = ints[i];
                if (cur[0] <= right) {
                    if (right >= end) {
                        break;
                    }
                } else {
                    sum += cur[0] - right;
                }
                right = Math.max(right,cur[1]);
            }
            System.out.println(sum);
        }
        input.close();
    }

    private static int[][] buildInts(int[] dp) {
        int[][] ints = new int[dp.length][];
        int index = 0;
        while (index < dp.length) {
            if (index == 0) {
                ints[index] = new int[]{0,dp[index]};
            } else {
                int mid = (index) * 100;
                ints[index] = new int[]{mid-dp[index],mid+dp[index]};
            }
            index++;
        }
        Arrays.sort(ints, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return b[1] - a[1];
                }
                return a[0] - b[0];
            }
        });
        return ints;
    }

    private static int[] buildDp(int len, Scanner input) {
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = input.nextInt();
        }
        return dp;
    }
}
