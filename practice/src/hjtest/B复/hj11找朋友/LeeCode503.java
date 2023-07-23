package hjtest.B复.hj11找朋友;

import java.util.Arrays;
import java.util.Stack;

public class LeeCode503 {
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result,-1);
        Stack<Integer> cursor = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!cursor.isEmpty() && nums[i] > nums[cursor.peek()]) {
                int index = cursor.pop();
                result[index] = nums[i];
            }
            cursor.push(i);
        }
        while (!cursor.isEmpty()) {
            int index = cursor.pop();
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
