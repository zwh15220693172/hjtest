package hjtest.leecode.动态规划;

import java.util.Arrays;

public class LeeCode70 {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        int[] steps = {1,2};
        dp[0] = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < steps.length; j++) {
                if (i - steps[j] >= 0) {
                    dp[i] += dp[i-steps[j]];
                }
            }
        }
        return dp[n];
    }
}
