package hjtest.B复200分.hj56二叉树遍历;

import java.util.Scanner;
import java.util.Stack;

/**
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String[] sources = input.nextLine().split("");
            Stack<String> stack = new Stack<>();
            Stack<String> cursor = new Stack<>();
            for (String cur : sources) {
                if ("}".equals(cur)) {
                    while (!stack.peek().equals("{")) {
                        String pop = stack.pop();
                        cursor.push(pop);
                    }
                    stack.pop();
                    String root = stack.pop();
                    String right;
                    String left;
                    if (cursor.size() == 3) {
                        left = cursor.pop();
                        cursor.pop();
                        right = cursor.pop();
                    } else if (cursor.size() == 2) {
                        cursor.pop();
                        right = cursor.pop();
                        left = "";
                    } else {
                        left = cursor.pop();
                        right = "";
                    }
                    String val = left + root + right;
                    stack.push(val);
                } else {
                    stack.push(cur);
                }
            }
            System.out.println(stack.pop());
        }
        input.close();
    }
}
