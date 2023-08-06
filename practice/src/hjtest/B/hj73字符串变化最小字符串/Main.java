package hjtest.B.hj73字符串变化最小字符串;

import java.util.Scanner;

// 所谓的字典序就是排序，但是把最后面小的排到前面
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String line = input.nextLine();
            char[] chars = line.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char cur = chars[i];
                int index = i;
                for (int j = chars.length - 1; j > i; j--) {
                    if (chars[j] < cur) {
                        cur = chars[j];
                        index = j;
                    }
                }
                if (index != i) {
                    chars[index] = chars[i];
                    chars[i] = cur;
                    break;
                }
            }
            System.out.println(new String(chars));
        }
        input.close();
    }
}
