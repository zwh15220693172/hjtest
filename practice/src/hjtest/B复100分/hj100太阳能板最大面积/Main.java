package hjtest.B复100分.hj100太阳能板最大面积;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] ints = getInts(input.nextLine());
            long max = Integer.MIN_VALUE;
            for (int i = 0; i < ints.length; i++) {
                for (int j = i + 1; j < ints.length; j++) {
                    long cur = (long) Math.min(ints[i], ints[j]) * (j - i);
                    max = Math.max(cur, max);
                }
            }
            System.out.println(max);
        }
        input.close();
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
