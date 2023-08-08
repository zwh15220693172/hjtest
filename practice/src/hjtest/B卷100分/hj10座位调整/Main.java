package hjtest.B卷100分.hj10座位调整;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 记住要判断当前座位是否为0
 * 要注意小心只有一个位置并且为0的情况
 * 100%
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] ints = getInts(input.nextLine());
            if (ints.length == 1 && ints[0] == 0) {
                System.out.println(1);
            } else {
                int count = 0;
                for (int i = 0; i < ints.length; i++) {
                    if (i == 0) {
                        if (i + 1 < ints.length && ints[i] == 0 && ints[i+1] == 0) {
                            ints[i] = 1;
                            count++;
                        }
                    } else if (i == ints.length - 1) {
                        if (i - 1 > 0 && ints[i] == 0 && ints[i-1] == 0) {
                            ints[i] = 1;
                            count++;
                        }
                    } else {
                        if (ints[i] == 0 && ints[i-1] == 0 && ints[i+1] == 0) {
                            ints[i] = 1;
                            count++;
                        }
                    }
                }
                System.out.println(count);
            }
        }
        input.close();
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(","))
                .mapToInt(Integer::parseInt).toArray();
    }
}
