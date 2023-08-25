package hjtest.leecode.单调栈;

import java.util.Stack;

public class LeeCode402 {
    public static void main(String[] args) {
        String num = "100";
        int k = 1;
        System.out.println(removeKdigits(num, k));
    }

    public static String removeKdigits(String num, int k) {
        char[] chars = num.toCharArray();
        Stack<Character> cursor = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char cur = chars[i];
            while (k > 0 && !cursor.isEmpty() && cur < cursor.peek()) {
                cursor.pop();
                k--;
            }
            cursor.push(cur);
        }
        for (int i = 0; i < k; i++) {
            cursor.pop();
        }
        StringBuilder res = new StringBuilder();
        while (!cursor.isEmpty()) {
            Character cur = cursor.pop();
            res.insert(0,cur);
        }
        String result = res.toString();
        char[] returnChars = result.toCharArray();
        StringBuilder returnBuilder = new StringBuilder();
        boolean startZero = true;
        for (int i = 0; i < returnChars.length; i++) {
            char cur = returnChars[i];
            if (cur != '0') {
                startZero = false;
            }
            if (!startZero) {
                returnBuilder.append(cur);
            }
        }
        if (returnBuilder.length() == 0) {
            return "0";
        }
        return returnBuilder.toString();
    }
}
