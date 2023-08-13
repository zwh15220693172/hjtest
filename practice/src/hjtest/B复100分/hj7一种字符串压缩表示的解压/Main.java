package hjtest.B复100分.hj7一种字符串压缩表示的解压;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            char[] chars = input.nextLine().toCharArray();
            if (errorChars(chars)) {
                System.out.println("!error");
            } else {
                boolean error = false;
                int index = 0;
                StringBuilder result = new StringBuilder();
                while (index < chars.length) {
                    char cur = chars[index];
                    if (Character.isLetter(cur)) {
                        result.append(cur);

                    } else {
                        StringBuilder digitBuilder = new StringBuilder();
                        while (index < chars.length && Character.isDigit(chars[index])) {
                            digitBuilder.append(chars[index]);
                            index++;
                        }
                        String digitStr = digitBuilder.toString();
                        if (digitStr.startsWith("0")) {
                            error = true;
                            break;
                        }
                        int digit = Integer.parseInt(digitStr);
                        if (digit <= 2) {
                            error = true;
                            break;
                        }
                        if (index >= chars.length) {
                            error = true;
                            break;
                        }
                        char curChar = chars[index];
                        char nextChar = findNextChar(index,chars);
                        if (curChar == nextChar) {
                            error = true;
                            break;
                        }
                        for (int i = 0; i < digit; i++) {
                            result.append(curChar);
                        }
                    }
                    index++;
                }
                if (error) {
                    System.out.println("!error");
                } else {
                    System.out.println(result);
                }
            }
        }
        input.close();
    }

    private static char findNextChar(int index, char[] chars) {
        for (int i = index + 1; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                return chars[i];
            }
        }
        return ' ';
    }

    private static boolean errorChars(char[] chars) {
        char pre = ' ';
        int count = 1;
        for (int i = 0; i < chars.length; i++) {
            char cur = chars[i];
            if (!Character.isLetterOrDigit(cur)) {
                return true;
            }
            if (Character.isLetter(cur)) {
                if (cur >= 'A' && cur <= 'Z') {
                    return true;
                }
            }
            if (cur == pre) {
                count++;
                if (count > 2) {
                    return true;
                }
            } else {
                pre = cur;
                count = 1;
            }
        }
        return false;
    }
}
