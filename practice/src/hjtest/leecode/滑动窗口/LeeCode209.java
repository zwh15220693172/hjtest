package hjtest.leecode.滑动窗口;

public class LeeCode209 {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int len = nums.length;
        int min = Integer.MAX_VALUE;
        while (right < len) {
            sum += nums[right];
            while (sum >= target) {
                int cur = right - left + 1;
                min = Math.min(cur, min);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
