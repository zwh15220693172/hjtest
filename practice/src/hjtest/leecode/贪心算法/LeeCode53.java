package hjtest.leecode.贪心算法;

public class LeeCode53 {
    public int maxSubArray(int[] nums) {
        int left = 0;
        int cur = 0;
        int sum = Integer.MIN_VALUE;
        while (left < nums.length) {
            cur += nums[left++];
            sum = Math.max(cur,sum);
            if (cur < 0) {
                cur = 0;
            }
        }
        return sum;
    }
}
