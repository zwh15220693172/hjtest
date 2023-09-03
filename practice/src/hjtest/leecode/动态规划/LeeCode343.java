package hjtest.leecode.动态规划;

public class LeeCode343 {
    public int integerBreak(int n) {
        if (n <= 2) {
            return 1;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 1; j < i; j++) {
                int cur = Math.max(Math.max(j * (i-j),dp[j] * (i-j)), dp[j] * dp[i-j]);
                max = Math.max(cur,max);
            }
            dp[i] = max;
        }
        return dp[n];
    }
}
