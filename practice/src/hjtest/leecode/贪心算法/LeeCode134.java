package hjtest.leecode.贪心算法;

import java.util.Arrays;

public class LeeCode134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] dp = getDp(gas,cost);
        int sum = 0;
        int cur = 0;
        int start = 0;
        for (int i = 0; i < dp.length; i++) {
            sum += dp[i];
            cur += dp[i];
            if (cur < 0) {
                start = i + 1;
                cur = 0;
            }
        }
        if (sum < 0) {
            return -1;
        }
        return start;
    }

    private int[] getDp(int[] gas, int[] cost) {
        int len = gas.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = gas[i] - cost[i];
        }
        return dp;
    }
}
