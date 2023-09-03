package hjtest.leecode.单调栈;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class LeeCode496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        Arrays.fill(result,-1);
        HashMap<Integer,Integer> numBigger = new HashMap<>();
        Stack<Integer> cursor = new Stack<>();
        for (int cur : nums2) {
            while (!cursor.isEmpty() && cur > cursor.peek()) {
                int last = cursor.pop();
                numBigger.put(last,cur);
            }
            cursor.push(cur);
        }
        for (int i = 0; i < nums1.length; i++) {
            int cur = nums1[i];
            if (numBigger.containsKey(cur)) {
                int val = numBigger.get(cur);
                result[i] = val;
            }
        }
        return result;
    }
}
