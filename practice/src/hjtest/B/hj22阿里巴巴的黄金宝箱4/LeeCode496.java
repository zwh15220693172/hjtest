package hjtest.B.hj22阿里巴巴的黄金宝箱4;

import java.util.Arrays;
import java.util.Stack;

public class LeeCode496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] answers = getAnswer(nums2);
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = answers[nums1[i]];
        }
        return result;
    }

    private int[] getAnswer(int[] nums2) {
        int max = getMax(nums2);
        int[] answers = new int[max+1];
        Arrays.fill(answers,-1);
        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && num > stack.peek()) {
                int last = stack.pop();
                answers[last] = num;
            }
            stack.add(num);
        }
        return answers;
    }

    private int getMax(int[] nums2) {
        return Arrays.stream(nums2).max().getAsInt();
    }
}
