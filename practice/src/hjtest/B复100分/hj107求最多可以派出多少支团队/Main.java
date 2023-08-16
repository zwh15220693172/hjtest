package hjtest.B复100分.hj107求最多可以派出多少支团队;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextInt()) {
            int len = input.nextInt();
            int[] ints = getInts(len, input);
            int target = input.nextInt();
            int left = 0;
            int right = ints.length - 1;
            int count = 0;
            while (left <= right) {
                if (ints[right] >= target) {
                    right--;
                    count++;
                    continue;
                }
                if (left != right && ints[right] + ints[left] >= target) {
                    count++;
                    right--;
                    left++;
                } else {
                    left++;
                }
            }
            System.out.println(count);
        }
        input.close();
    }

    private static int[] getInts(int len, Scanner input) {
        int[] ints = new int[len];
        for (int i = 0; i < len; i++) {
            ints[i] = input.nextInt();
        }
        Arrays.sort(ints);
        return ints;
    }
}
