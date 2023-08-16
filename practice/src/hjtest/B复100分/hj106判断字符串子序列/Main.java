package hjtest.B复100分.hj106判断字符串子序列;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            char[] target = input.nextLine().toCharArray();
            char[] source = input.nextLine().toCharArray();
            int targetRight = target.length - 1;
            int sourceRight = source.length - 1;
            int result = -1;
            while (targetRight >=0 && sourceRight >=0) {
                if (source[sourceRight] == target[targetRight]) {
                    targetRight--;
                    if (targetRight < 0) {
                        result = sourceRight;
                        break;
                    }
                }
                sourceRight--;
            }
            System.out.println(result);
        }
        input.close();
    }
}
