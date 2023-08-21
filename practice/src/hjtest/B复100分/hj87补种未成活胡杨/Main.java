package hjtest.B复100分.hj87补种未成活胡杨;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int len = input.nextInt();
        int[] ints = getInts(len);
        setZero(ints, input);
        int k = input.nextInt();
        int left = 0;
        int right = 0;
        int zeroCount = 0;
        int max = -1;
        while (right < len) {
            if (ints[right] == 0) {
                zeroCount++;
            }
            if (zeroCount > k) {
                while (left < right && zeroCount > k) {
                    if (ints[left] == 0) {
                        zeroCount--;
                    }
                    left++;
                }
            }
            int cur = right - left + 1;
            max = Math.max(cur,max);
            right++;
        }
        System.out.println(max);
    }

    private static void setZero(int[] ints, Scanner input) {
        int m = input.nextInt();
        while (m > 0) {
            int index = input.nextInt() - 1;
            ints[index] = 0;
            m--;
        }
    }

    private static int[] getInts(int len) {
        int[] ints = new int[len];
        Arrays.fill(ints,1);
        return ints;
    }
}
