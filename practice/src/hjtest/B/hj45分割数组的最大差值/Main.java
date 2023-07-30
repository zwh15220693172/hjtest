package hjtest.B.hj45分割数组的最大差值;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int len = Integer.parseInt(input.nextLine());
            int[] ints = getInts(input.nextLine());
            int[] dp = new int[len+1];
            init(dp, ints);
            int max = Integer.MIN_VALUE;
            for (int i = 1; i < dp.length - 1; i++) {
                int right = dp[len] - dp[i];
                int cur = Math.abs(dp[i] - right);
                max = Math.max(max, cur);
            }
            System.out.println(max);
        }
        input.close();
    }

    private static void init(int[] dp, int[] ints) {
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i-1] + ints[i-1];
        }
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
