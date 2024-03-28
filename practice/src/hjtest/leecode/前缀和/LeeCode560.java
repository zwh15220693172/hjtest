package hjtest.leecode.前缀和;

import java.util.Arrays;

public class LeeCode560 {
    public int subarraySum(int[] nums, int k) {
        int[] dp = buildDp(nums);
        int count = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = i + 1; j < dp.length; j++) {
                int cur = dp[j] - dp[i];
                if (cur == k) {
                    count++;
                }
            }
        }
        return count;
    }

    private int[] buildDp(int[] nums) {
        int[] dp = new int[nums.length+1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i-1] + nums[i-1];
        }
        return dp;
    }
}
