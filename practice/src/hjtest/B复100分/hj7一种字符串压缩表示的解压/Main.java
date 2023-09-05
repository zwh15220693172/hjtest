package hjtest.B复100分.hj7一种字符串压缩表示的解压;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            char[] chars = input.nextLine().toCharArray();
            if (error(chars)) {
                System.out.println("!error");
            } else {
                getResult(chars);
            }
        }
        input.close();
    }

    private static void getResult(char[] chars) {
        boolean error = false;
        int index = 0;
        int len = chars.length;
        StringBuilder res = new StringBuilder();
        while (index < len) {
            char cur = chars[index];
            if (Character.isLetter(cur)) {
                res.append(cur);
                index++;
                continue;
            }
            StringBuilder digitBuilder = new StringBuilder();
            while (index < len && Character.isDigit(chars[index])) {
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
            if (index >= len) {
                error = true;
                break;
            }
            char letter = chars[index];
            for (int i = 0; i < digit; i++) {
                res.append(letter);
            }
            index++;
            char nextLetter = findNextLetter(index,chars);
            if (letter == nextLetter) {
                error = true;
                break;
            }
        }
        if (error) {
            System.out.println("!error");
        } else {
            System.out.println(res);
        }
    }

    private static char findNextLetter(int index, char[] chars) {
        for (int i = index; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                return chars[i];
            }
        }
        return ' ';
    }

    private static boolean error(char[] chars) {
        char pre = ' ';
        int count = 1;
        for (char cur : chars) {
            if (!(Character.isLetterOrDigit(cur))) {
                return true;
            }
            if (Character.isLetter(cur)) {
                if (cur >= 'A' && cur <= 'Z') {
                    return true;
                }
            }
            if (Character.isLetter(cur)) {
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
        }
        return false;
    }
}
