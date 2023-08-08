package hjtest.B卷100分.hj07阿里巴巴的黄金宝箱4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 100%
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] ints = getInts(input.nextLine());
            int len = Integer.parseInt(input.nextLine());
            int[] dp = getDp(ints);
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < dp.length - len; i++) {
                int cur = dp[i+len] - dp[i];
                max = Math.max(cur,max);
            }
            System.out.println(max);
        }
        input.close();
    }

    private static int[] getDp(int[] ints) {
        int[] dp = new int[ints.length+1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i-1] + ints[i-1];
        }
        return dp;
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(","))
                .mapToInt(Integer::parseInt).toArray();
    }
}
