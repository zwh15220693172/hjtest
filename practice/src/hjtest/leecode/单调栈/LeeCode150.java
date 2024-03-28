package hjtest.leecode.单调栈;

import java.util.Stack;

public class LeeCode150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numStack = new Stack<>();
        for (String token : tokens) {
            if (operator(token)) {
                calResult(numStack, token);
            } else {
                numStack.push(Integer.parseInt(token));
            }
        }
        return numStack.pop();
    }

    private void calResult(Stack<Integer> numStack, String token) {
        int num1 = numStack.pop();
        int num2 = numStack.pop();
        int result;
        if ("+".equals(token)) {
            result = num1 + num2;
        } else if ("-".equals(token)) {
            result = num2 - num1;
        } else if ("*".equals(token)) {
            result = num2 * num1;
        } else {
            result = num2 / num1;
        }
        numStack.push(result);
    }

    private boolean operator(String token) {
        return token.length() == 1 && !Character.isDigit(token.charAt(0));
    }
}
