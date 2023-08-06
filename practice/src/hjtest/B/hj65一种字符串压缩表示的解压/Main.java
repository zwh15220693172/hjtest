package hjtest.B.hj65一种字符串压缩表示的解压;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            char[] inputChars = input.nextLine().toCharArray();
            if (errorInput(inputChars)) {
                System.out.println("!error");
            } else {
                String result = getResult(inputChars);
                System.out.println(result);
            }
        }
        input.close();
    }

    private static String getResult(char[] inputChars) {
        StringBuilder result = new StringBuilder();
        int index = 0;
        int len = inputChars.length;
        boolean error = false;
        while (index < len) {
            char cur = inputChars[index];
            if (Character.isLetter(cur)) {
                result.append(cur);
                index++;
                continue;
            }
            StringBuilder digitBuilder = new StringBuilder();
            while (index < len && Character.isDigit(inputChars[index])) {
                digitBuilder.append(inputChars[index]);
                index++;
            }
            char curChar = ' ';
            if (index < len) {
                curChar = inputChars[index++];
            }
            if (curChar == ' ') {
                error = true;
                break;
            }
            int digit = Integer.parseInt(digitBuilder.toString());
            if (digit <= 2) {
                error = true;
                break;
            }
            char nextChar = getNextChar(index, inputChars);
            if (nextChar == curChar) {
                error = true;
                break;
            }
            for (int i = 0; i < digit; i++) {
                result.append(curChar);
            }
        }
        if (error) {
            return "!error";
        }
        return result.toString();
    }

    private static char getNextChar(int index, char[] inputChars) {
        for (int i = index; i < inputChars.length; i++) {
            if (Character.isLetter(inputChars[i])) {
                return inputChars[i];
            }
        }
        return ' ';
    }

    private static boolean errorInput(char[] inputChars) {
        char pre = ' ';
        int count = 1;
        for (int i = 0; i < inputChars.length; i++) {
            char cur = inputChars[i];
            if (!Character.isLetterOrDigit(cur)) {
                return true;
            }
            if (Character.isLetter(cur)) {
                if (cur < 'a') {
                    return true;
                }
                if (cur == pre) {
                    count++;
                    if (count == 3) {
                        return true;
                    }
                } else {
                    pre = cur;
                    count = 1;
                }
            }
        }
        return false;
    }
}
