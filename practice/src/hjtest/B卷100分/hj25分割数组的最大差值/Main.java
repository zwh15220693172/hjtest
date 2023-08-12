package hjtest.B卷100分.hj25分割数组的最大差值;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 前缀和解决这个问题
 * 超时，注意两边的边界问题，左右两边不能为0
 * 所以初始化dp的时候，dp[0] = ints[0]
 * 并且这个for循环不走到dp.length - 1
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int len = Integer.parseInt(input.nextLine());
            int[] ints = getInts(input.nextLine());
            int[] dp = buildDp(len,ints);
            int max = Integer.MIN_VALUE;
            int end = dp[dp.length-1];
            for (int i = 0; i < dp.length - 1; i++) {
                int left = dp[i];
                int right = end - dp[i];
                int cur = Math.abs(right-left);
                max = Math.max(cur,max);
            }
            System.out.println(max);
        }
        input.close();
    }

    private static int[] buildDp(int len, int[] ints) {
        int[] dp = new int[len];
        dp[0] = ints[0];
        for (int i = 1; i < ints.length; i++) {
            dp[i] = dp[i-1] + ints[i];
        }
        return dp;
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
