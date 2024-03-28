package hjtest.leecode.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeeCode713 {

    public static void main(String[] args) {
        int[] nums = {10,9,10,4,3,8,3,3,6,2,10,10,9,3};
        int k = 19;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= k) {
                continue;
            }
            count++;
            int cur = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                cur *= nums[j];
                if (cur < k) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }
}
