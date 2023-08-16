package hjtest.B复100分.hj109事件推送;

import java.util.Scanner;

/**
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextInt()) {
            int m = input.nextInt();
            int n = input.nextInt();
            int r = input.nextInt();
            int[] ints01 = getInts(m,input);
            int[] ints02 = getInts(n,input);
            int left01 = 0;
            int left02 = 0;
            while (left01 < m && left02 < n) {
                if (ints01[left01] <= ints02[left02]) {
                    if (ints02[left02] - ints01[left01] <= r) {
                        System.out.println(ints01[left01] + " " + ints02[left02]);
                    }
                    left01++;
                } else {
                    left02++;
                }
            }
        }
        input.close();
    }

    private static int[] getInts(int len, Scanner input) {
        int[] ints = new int[len];
        for (int i = 0; i < len; i++) {
            ints[i] = input.nextInt();
        }
        return ints;
    }
}
