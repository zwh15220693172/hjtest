package hjtest.B复100分.hj39最长连续子序列;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] ints = getInts(input.nextLine());
            int target = Integer.parseInt(input.nextLine());
            int[] dp = getDp(ints);
            int max = -1;
            for (int i = 0; i < dp.length; i++) {
                for (int j = i + 1; j < dp.length; j++) {
                    if (dp[j] - dp[i] == target) {
                        int cur = j - i;
                        max = Math.max(cur,max);
                    }
                }
            }
            System.out.println(max);
        }
        input.close();
    }

    private static int[] getDp(int[] ints) {
        int[] dp = new int[ints.length+1];
        dp[0] = 0;
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
