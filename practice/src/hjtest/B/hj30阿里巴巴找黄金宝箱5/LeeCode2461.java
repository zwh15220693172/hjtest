package hjtest.B.hj30阿里巴巴找黄金宝箱5;

import java.util.*;

public class LeeCode2461 {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> numCount = new HashMap<>();
        long max = 0;
        long sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
            numCount.put(nums[i],numCount.getOrDefault(nums[i],0)+1);
        }
        if (numCount.size() == k) {
            max = Math.max(sum,max);
        }
        for (int i = k; i < nums.length; i++) {
            int add = nums[i];
            sum += add;
            numCount.put(add,numCount.getOrDefault(add,0)+1);

            int remove = nums[i - k];
            sum -= remove;
            numCount.put(remove,numCount.get(remove)-1);

            if (numCount.get(remove) == 0) {
                numCount.remove(remove);
            }

            if (numCount.size() == k) {
                max = Math.max(sum,max);
            }
        }
        return max;
    }
}
