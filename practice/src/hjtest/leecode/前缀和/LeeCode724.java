package hjtest.leecode.前缀和;

public class LeeCode724 {
    public int pivotIndex(int[] nums) {
        int[] dp = buildDp(nums);
        for (int i = 1; i < dp.length; i++) {
            int left = dp[i-1];
            int right = dp[dp.length-1] - dp[i];
            if (left == right) {
                return i - 1;
            }
        }
        return -1;
    }

    private int[] buildDp(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len+1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i-1] + nums[i-1];
        }
        return dp;
    }
}
