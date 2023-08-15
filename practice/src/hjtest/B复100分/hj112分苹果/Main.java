package hjtest.B复100分.hj112分苹果;

import java.util.Scanner;

/**
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextInt()) {
            int len = input.nextInt();
            int[] apples = getApples(len,input);
            int cur = 0;
            int sum = 0;
            int min = Integer.MAX_VALUE;
            for (int apple : apples) {
                cur ^= apple;
                sum += apple;
                min = Math.min(apple,min);
            }
            if (cur == 0) {
                System.out.println(sum - min);
            } else {
                System.out.println(-1);
            }
        }
        input.close();
    }

    private static int[] getApples(int len, Scanner input) {
        int[] apples = new int[len];
        for (int i = 0; i < len; i++) {
            apples[i] = input.nextInt();
        }
        return apples;
    }
}
