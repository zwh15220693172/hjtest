package hjtest.B复200分.hj31找最小数;

import java.util.Scanner;
import java.util.Stack;

/**
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            char[] source = input.nextLine().toCharArray();
            int k = Integer.parseInt(input.nextLine());
            Stack<Character> cursor = new Stack<>();
            for (char cur : source) {
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
                char cur = cursor.pop();
                res.append(cur);
            }
            String reverse = res.reverse().toString();
            StringBuilder returnBuilder = new StringBuilder();
            char[] reverseChars = reverse.toCharArray();
            boolean startEnd = true;
            for (char reverseChar : reverseChars) {
                if (reverseChar != '0') {
                    startEnd = false;
                }
                if (!startEnd) {
                    returnBuilder.append(reverseChar);
                }
            }
            if (returnBuilder.length() == 0) {
                System.out.println("0");
            } else {
                System.out.println(returnBuilder);
            }
        }
        input.close();
    }
}
