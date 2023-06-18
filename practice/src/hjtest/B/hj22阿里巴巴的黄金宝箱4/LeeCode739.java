package hjtest.B.hj22阿里巴巴的黄金宝箱4;

import java.util.Stack;

public class LeeCode739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> indexStack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!indexStack.isEmpty() && temperatures[i] > temperatures[indexStack.peek()]) {
                int index = indexStack.pop();
                int len = i - index;
                result[index] = len;
            }
            indexStack.add(i);
        }
        return result;
    }
}
