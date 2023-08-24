package hjtest.leecode.贪心算法;

public class LeeCode55 {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int cur = 0;
        while (nums[cur] != 0) {
            if (cur + nums[cur] >= nums.length - 1) {
                return true;
            }
            int max = Integer.MIN_VALUE;
            int next = -1;
            for (int i = cur; i <= cur + nums[cur]; i++) {
                int len = i + nums[i];
                if (len > max) {
                    max = len;
                    next = i;
                }
            }
            if (next == cur) {
                return false;
            }
            cur = next;
        }
        return false;
    }
}
