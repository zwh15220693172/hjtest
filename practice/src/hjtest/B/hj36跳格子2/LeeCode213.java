package hjtest.B.hj36跳格子2;

public class LeeCode213 {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0],nums[1]);
        } else if (nums.length == 3) {
            return Math.max(Math.max(nums[0],nums[1]),nums[2]);
        } else {
            int max1 = getMax(getInts(1, nums.length - 1, nums));
            int max2 = getMax(getInts(0, nums.length - 1, nums));
            int max3 = getMax(getInts(1, nums.length, nums));
            return Math.max(Math.max(max1,max2),max3);
        }
    }

    private int getMax(int[] array) {
        if (array.length == 1) {
            return array[0];
        }
        if (array.length == 2) {
            return Math.max(array[0],array[1]);
        }
        int[] dp = new int[array.length];
        dp[0] = array[0];
        dp[1] = Math.max(array[0],array[1]);
        for (int i = 2; i < array.length; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+array[i]);
        }
        return dp[dp.length-1];
    }

    private int[] getInts(int start, int end, int[] base) {
        int[] array = new int[end-start];
        int index = 0;
        for (int i = start; i < end; i++) {
            array[index++] = base[i];
        }
        return array;
    }
}
