package hjtest.B复200分.hj09报文解压缩;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String[] strings = input.nextLine().split("");
            int index = 0;
            int len = strings.length;
            Stack<String> cursor = new Stack<>();
            while (index < len) {
                String cur = strings[index];
                if (isDigit(cur)) {
                    StringBuilder digitBuilder = new StringBuilder();
                    while (isDigit(cur)) {
                        digitBuilder.append(cur);
                        index++;
                        cur = strings[index];
                    }
                    String digitStr = digitBuilder.toString();
                    cursor.push(digitStr);
                } else if (cur.equals("]")) {
                    StringBuilder strBuilder = new StringBuilder();
                    while (!cursor.peek().equals("[")) {
                        String pop = cursor.pop();
                        strBuilder.append(pop);
                    }
                    cursor.pop();
                    String str = strBuilder.toString();
                    int digit = Integer.parseInt(cursor.pop());
                    for (int i = 0; i < digit; i++) {
                        cursor.push(str);
                    }
                    index++;
                } else {
                    cursor.push(cur);
                    index++;
                }
            }
            StringBuilder resultBuilder = new StringBuilder();
            while (!cursor.isEmpty()) {
                resultBuilder.append(cursor.pop());
            }
            StringBuilder reverse = resultBuilder.reverse();
            System.out.println(reverse);
        }
        input.close();
    }

    private static boolean isDigit(String cur) {
        return Character.isDigit(cur.charAt(0));
    }
}
