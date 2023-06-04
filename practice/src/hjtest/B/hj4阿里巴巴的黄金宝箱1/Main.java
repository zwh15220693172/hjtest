package hjtest.B.hj4阿里巴巴的黄金宝箱1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] ints = getInts(input.nextLine());
            int[] dp = getDp(ints);
            System.out.println(getResult(dp));
        }
        input.close();
    }

    private static int getResult(int[] dp) {
        int end = dp.length - 1;
        for (int i = 1; i < dp.length; i++) {
            if (dp[i-1] == dp[end] - dp[i]) {
                return i - 1;
            }
        }
        return -1;
    }

    private static int[] getDp(int[] ints) {
        int[] dp = new int[ints.length+1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i-1] + ints[i-1];
        }
        return dp;
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(","))
                .mapToInt(Integer::parseInt).toArray();
    }
}
