package hjtest.A.hj15探索地块建立;

public class LeeCode560 {
    public int subarraySum(int[] nums, int k) {
        int[] dp = getDp(nums);
        int count = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[i] - dp[j] == k) {
                    count++;
                }
            }
        }
        return count;
    }

    private int[] getDp(int[] nums) {
        int[] dp = new int[nums.length+1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i-1] + nums[i-1];
        }
        return dp;
    }
}
