package hjtest.leecode.贪心算法;

public class LeeCode45 {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int cur = 0;
        int count = 1;
        while (cur+nums[cur] < nums.length - 1) {
            int start = cur + 1;
            int end = nums[cur] + cur;
            int max = Integer.MIN_VALUE;
            int next = -1;
            for (int i = start; i <= end; i++) {
                if (i + nums[i] > max) {
                    max = i + nums[i];
                    next = i;
                }
            }
            cur = next;
            count++;
        }
        return count;
    }
}
