package hjtest.leecode.动态规划;

public class LeeCode746 {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int[] dp = new int[len];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < len; i++) {
            int cur = Math.min(dp[i-1],dp[i-2]);
            dp[i] = cur + cost[i];
        }
        return Math.min(dp[len-1],dp[len-2]);
    }
}
