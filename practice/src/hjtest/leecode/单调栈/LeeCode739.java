package hjtest.leecode.单调栈;

import java.util.Stack;

public class LeeCode739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> indexStack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!indexStack.isEmpty() && temperatures[i] > temperatures[indexStack.peek()]) {
                int index  = indexStack.pop();
                result[index] = i - index;
            }
            indexStack.push(i);
        }
        return result;
    }
}
