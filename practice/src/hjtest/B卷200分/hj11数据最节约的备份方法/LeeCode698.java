package hjtest.B卷200分.hj11数据最节约的备份方法;

import java.util.Arrays;

public class LeeCode698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        Arrays.sort(nums);
        int target = sum / k;
        int[] bucket = new int[k];
        return backtracking(nums.length-1,nums,bucket,target);
    }

    private boolean backtracking(int index, int[] nums, int[] bucket, int target) {
        if (index < 0) {
            return true;
        }
        for (int i = 0; i < bucket.length; i++) {
            if (i > 0 && bucket[i] == bucket[i-1]) {
                continue;
            }
            int cur = nums[index];
            if (bucket[i] + cur <= target) {
                bucket[i]+=cur;
                if (backtracking(index-1,nums,bucket,target)) {
                    return true;
                }
                bucket[i]-=cur;
            }
        }
        return false;
    }
}
