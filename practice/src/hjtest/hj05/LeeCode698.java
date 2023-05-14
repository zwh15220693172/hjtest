package hjtest.hj05;

import java.util.Arrays;

public class LeeCode698 {

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 3, 5, 2, 1};
        int k = 4;
        System.out.println(canPartitionKSubsets(nums, k));
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        int[] array = new int[k];
        Arrays.fill(array, target);
        Arrays.sort(nums);
        return backtracking(nums, nums.length - 1, array);
    }

    private static boolean backtracking(int[] nums, int cur, int[] array) {
        if (cur < 0) {
            return true;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                break;
            }
            if (array[i] == nums[cur] || array[i] - nums[cur] >= nums[0]) {
                array[i] -= nums[cur];
                if (backtracking(nums, cur-1, array)) {
                    return true;
                }
                array[i] += nums[cur];
            }
        }
        return false;
    }
}
