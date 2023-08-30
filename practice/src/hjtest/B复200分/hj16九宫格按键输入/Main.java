package hjtest.B复200分.hj16九宫格按键输入;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    private static final String[][] buttons = {
            {},
            {},
            {"c","a","b"},
            {"f","d","e"},
            {"i","g","h"},
            {"l","j","k"},
            {"o","m","n"},
            {"s","p","q","r"},
            {"v","t","u"},
            {"z","w","x","y"},
    };

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            char[] source = input.nextLine().toCharArray();
            boolean digitModel = true;
            Stack<Character> cursor = new Stack<>();
            StringBuilder res = new StringBuilder();
            for (char cur : source) {
                if (cur == '#') {
                    digitModel = !digitModel;
                } else if (cur == '/') {
                    append(res,cursor);
                } else {
                    if (digitModel) {
                        res.append(cur);
                    } else {
                        if (!cursor.isEmpty() && cur != cursor.peek()) {
                            append(res,cursor);
                        }
                        cursor.push(cur);
                    }
                }
            }
            append(res,cursor);
            System.out.println(res);
        }
        input.close();
    }

    private static void append(StringBuilder res, Stack<Character> cursor) {
        if (cursor.isEmpty()) {
            return;
        }
        int index = cursor.peek() - '0';
        String[] button = buttons[index];
        int buttonIndex = cursor.size() % button.length;
        res.append(button[buttonIndex]);
        cursor.clear();
    }
}
