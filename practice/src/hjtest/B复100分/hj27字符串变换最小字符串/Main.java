package hjtest.B复100分.hj27字符串变换最小字符串;

import java.util.Scanner;

/**
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            char[] chars = input.nextLine().toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char min = chars[i];
                int minIndex = i;
                for (int j = chars.length - 1; j > i; j--) {
                    char cur = chars[j];
                    if (cur < min) {
                        min = cur;
                        minIndex = j;
                    }
                }
                if (minIndex != i) {
                    chars[minIndex] = chars[i];
                    chars[i] = min;
                    break;
                }
            }
            System.out.println(new String(chars));
        }
        input.close();
    }
}
