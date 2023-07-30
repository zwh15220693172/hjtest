package hjtest.B.hj45分割数组的最大差值;

public class LeeCode560 {
    public int subarraySum(int[] nums, int k) {
        int[] dp = initDp(nums);
        int count = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = i + 1; j < dp.length; j++) {
                if (dp[j] < k) {
                    continue;
                }
                int cur = dp[j] - dp[i];
                if (cur == k) {
                    count++;
                }
            }
        }
        return count;
    }

    private int[] initDp(int[] nums) {
        int[] dp = new int[nums.length+1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i-1] + nums[i-1];
        }
        return dp;
    }
}
