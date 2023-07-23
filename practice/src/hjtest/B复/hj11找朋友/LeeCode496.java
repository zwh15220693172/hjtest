package hjtest.B复.hj11找朋友;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class LeeCode496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Arrays.fill(result,-1);
        HashMap<Integer,Integer> numBigger = new HashMap<>();
        Stack<Integer> cursor = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!cursor.isEmpty() && nums2[i] > cursor.peek()) {
                int num = cursor.pop();
                numBigger.put(num,nums2[i]);
            }
            cursor.push(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            if (numBigger.containsKey(nums1[i])) {
                result[i] = numBigger.get(nums1[i]);
            }
        }
        return result;
    }
}