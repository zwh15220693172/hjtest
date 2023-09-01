package hjtest.B复200分.hj37没有回文串;

import java.util.Scanner;

/**
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int len = Integer.parseInt(input.nextLine());
            char[] chars = input.nextLine().toCharArray();
            String result = getResult(len, chars);
            System.out.println(result);
        }
        input.close();
    }

    private static String getResult(int len, char[] chars) {
        int index = chars.length - 1;
        char max = (char)('a' + len - 1);
        boolean back = false;
        while (index >= 0) {
            if (chars[index] < max) {
                if (!back) {
                    chars[index]++;
                }
                if (index - 1 >= 0 && chars[index] == chars[index-1]) {
                    back = false;
                    continue;
                }
                if (index - 2 >= 0 && chars[index] == chars[index-2]) {
                    back = false;
                    continue;
                }
                if (index == chars.length - 1) {
                    return new String(chars);
                }
                back = true;
                index++;
            } else {
                chars[index] = 'a';
                index--;
            }
        }
        return "NO";
    }
}
