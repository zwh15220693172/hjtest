package hjtest.A.hj5等和子数组最小和;

import java.util.Arrays;

public class LeeCode698 {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        Arrays.sort(nums);
        int[] bucket = new int[k];
        Arrays.fill(bucket, target);
        return backtracking(nums, nums.length-1, bucket);
    }

    private boolean backtracking(int[] nums, int index, int[] bucket) {
        if (index < 0) {
            return true;
        }
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] == 0) {
                break;
            }
            if (bucket[i] - nums[index] == 0 || bucket[i] - nums[index] >= nums[0]) {
                bucket[i] -= nums[index];
                if (backtracking(nums, index-1, bucket)) {
                    return true;
                }
                bucket[i] += nums[index];
            }
        }
        return false;
    }
}
