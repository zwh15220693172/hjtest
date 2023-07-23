package hjtest.A.hj16日志首次上报最多的积分;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] ints = getInts(input.nextLine());
            int[] dp = getDp(ints);
            int asInt = Arrays.stream(dp).max().getAsInt();
            System.out.println(asInt);
        }
        input.close();
    }

    private static int[] getDp(int[] ints) {
        int[] dp = new int[ints.length];
        dp[0] = ints[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i-1] + ints[i];
            if (dp[i] > 100) {
                dp[i] = 100;
            }
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] -= (i - j) * ints[j];
            }
        }
        return dp;
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
