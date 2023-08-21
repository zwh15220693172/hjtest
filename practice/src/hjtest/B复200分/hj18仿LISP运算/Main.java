package hjtest.B复200分.hj18仿LISP运算;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String[] source = getSource(input.nextLine());
            Stack<String> operators = new Stack<>();
            Stack<Integer> digits = new Stack<>();
            boolean error = false;
            for (String cur : source) {
                if (cur.isEmpty()) {
                    continue;
                }
                if (isDigit(cur)) {
                    digits.push(new Integer(cur));
                } else if (cur.equals("(")) {
                    continue;
                } else if (cur.equals(")")) {
                    int digit2 = digits.pop();
                    int digit1 = digits.pop();
                    String operator = operators.pop();
                    if (operator.equals("mul")) {
                        digits.push(mul(digit1,digit2));
                    } else if (operator.equals("add")) {
                        digits.push(add(digit1,digit2));
                    } else if (operator.equals("sub")) {
                        digits.push(sub(digit1,digit2));
                    } else {
                        if (digit2 == 0) {
                            error = true;
                            break;
                        }
                        digits.push(divide(digit1,digit2));
                    }
                } else {
                    operators.push(cur);
                }
            }
            if (error) {
                System.out.println("error");
            } else {
                System.out.println(digits.pop());
            }
        }
        input.close();
    }

    private static boolean isDigit(String cur) {
        return Character.isDigit(cur.charAt(cur.length()-1));
    }

    private static String[] getSource(String nextLine) {
        char[] chars = nextLine.toCharArray();
        StringBuilder res = new StringBuilder();
        for (char cur : chars) {
            if (cur == '(' || cur == ')') {
                res.append(" ").append(cur).append(" ");
            } else {
                res.append(cur);
            }
        }
        return res.toString().split(" ");
    }

    private static int divide(int num1, int num2) {
        return (int)Math.floor(num1 * 1.0 / num2);
    }

    private static int add(int num1, int num2) {
        return num1 + num2;
    }

    private static int sub(int num1, int num2) {
        return num1 - num2;
    }

    private static int mul(int num1, int num2) {
        return num1 * num2;
    }
}
