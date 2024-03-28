package hjtest.leecode.回溯;

import java.util.Arrays;

public class LeeCode698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        int max = Arrays.stream(nums).max().getAsInt();
        if (max > target) {
            return false;
        }
        Arrays.sort(nums);
        int[] dp = new int[k];
        return backtracking(nums.length-1, nums, dp, target);
    }

    private boolean backtracking(int index, int[] nums, int[] dp, int target) {
        if (index < 0) {
            return true;
        }
        for (int i = 0; i < dp.length; i++) {
            if (i > 0 && dp[i] == dp[i-1]) {
                continue;
            }
            if (dp[i] + nums[index] <= target) {
                dp[i] += nums[index];
                if (backtracking(index-1,nums,dp,target)) {
                    return true;
                }
                dp[i] -= nums[index];
            }
        }
        return false;
    }
}
