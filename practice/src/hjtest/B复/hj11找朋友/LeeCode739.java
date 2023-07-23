package hjtest.B复.hj11找朋友;

import java.util.Stack;

public class LeeCode739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> cursor = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!cursor.isEmpty() && temperatures[i] > temperatures[cursor.peek()]) {
                int index = cursor.pop();
                result[index] = i - index;
            }
            cursor.push(i);
        }
        return result;
    }
}
