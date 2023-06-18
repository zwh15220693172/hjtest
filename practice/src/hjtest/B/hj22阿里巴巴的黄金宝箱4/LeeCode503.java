package hjtest.B.hj22阿里巴巴的黄金宝箱4;

import java.util.Arrays;
import java.util.Stack;

public class LeeCode503 {

    public static void main(String[] args) {
        int[] nums = {1,2,1};
        System.out.println(nextGreaterElements(nums));
    }

    public static int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result,-1);
        Stack<Integer> indexStack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!indexStack.isEmpty() && nums[i] > nums[indexStack.peek()]) {
                int index = indexStack.pop();
                result[index] = nums[i];
            }
            indexStack.add(i);
        }
        while (!indexStack.isEmpty()) {
            int index = indexStack.pop();
            for (int i = 0; i < index; i++) {
                if (nums[i] > nums[index]) {
                    result[index] = nums[i];
                    break;
                }
            }
        }
        return result;
    }
}
