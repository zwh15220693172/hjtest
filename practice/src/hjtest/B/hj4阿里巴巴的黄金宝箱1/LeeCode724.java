package hjtest.B.hj4阿里巴巴的黄金宝箱1;

public class LeeCode724 {
    public int pivotIndex(int[] nums) {
        int[] dp = getDp(nums);
        return getResult(dp);
    }

    private int getResult(int[] dp) {
        int len = dp.length - 1;
        for (int i = 1; i < dp.length; i++) {
            if (dp[i-1] == dp[len] - dp[i]) {
                return i - 1;
            }
        }
        return -1;
    }

    private int[] getDp(int[] nums) {
        int[] dp = new int[nums.length+1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i-1] + nums[i-1];
        }
        return dp;
    }
}
