package hjtest.B复200分.hj16九宫格按键输入;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    private static final String[][] buttons = {
            {},
            {",","."},
            {"c","a","b"},
            {"f","d","e"},
            {"i","g","h"},
            {"l","j","k"},
            {"o","m","n"},
            {"s","p","q","r"},
            {"v","t","u"},
            {"z","w","x","y"}
    };

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            boolean isEng = false;
            StringBuilder resBuilder = new StringBuilder();
            char[] chars = input.nextLine().toCharArray();
            Stack<Character> cursor = new Stack<>();
            for (char button : chars) {
                if (button == '#') {
                    isEng = !isEng;
                    if (!cursor.isEmpty()) {
                        addEng(resBuilder,cursor);
                    }
                } else if (button == '/') {
                    addEng(resBuilder,cursor);
                } else {
                    if (!isEng) {
                        int num = button - '0';
                        resBuilder.append(num);
                    } else {
                        if (cursor.isEmpty()) {
                            cursor.push(button);
                        } else {
                            if (button == cursor.peek()) {
                                cursor.push(button);
                            } else {
                                addEng(resBuilder,cursor);
                                cursor.push(button);
                            }
                        }
                    }
                }
            }
            if (!cursor.isEmpty()) {
                addEng(resBuilder,cursor);
            }
            System.out.println(resBuilder);
        }
        input.close();
    }

    private static void addEng(StringBuilder resBuilder, Stack<Character> cursor) {
        char num = cursor.peek();
        int index = num - '0';
        String[] button = buttons[index];
        int buttonIndex = cursor.size() % button.length;
        resBuilder.append(button[buttonIndex]);
        cursor.clear();
    }
}
