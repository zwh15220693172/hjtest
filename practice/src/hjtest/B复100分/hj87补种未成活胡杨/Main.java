package hjtest.B复100分.hj87补种未成活胡杨;

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
            int[] ints = buildInts(len);
            int count = input.nextInt();
            setInts(count, input, ints);
            int k = input.nextInt();
            int left = 0;
            int right = 0;
            int max = getMax(ints);
            int zeroCount = 0;
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
                } else {
                    int cur = right - left + 1;
                    max = Math.max(cur,max);
                }
                right++;
            }
            System.out.println(max);
        }
        input.close();
    }

    private static int getMax(int[] ints) {
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == 1) {
                count++;
            } else {
                max = Math.max(count,max);
                count = 0;
            }
        }
        max = Math.max(count,max);
        return max;
    }

    private static void setInts(int count, Scanner input, int[] ints) {
        while (count > 0) {
            int index = input.nextInt() - 1;
            ints[index] = 0;
            count--;
        }
    }

    private static int[] buildInts(int len) {
        int[] ints = new int[len];
        Arrays.fill(ints,1);
        return ints;
    }
}
