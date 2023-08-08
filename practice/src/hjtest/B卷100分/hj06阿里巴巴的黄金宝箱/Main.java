package hjtest.B卷100分.hj06阿里巴巴的黄金宝箱;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 100%
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] ints = getInts(input.nextLine());
            int[] dp = getDp(ints);
            int result = -1;
            int end = dp[dp.length-1];
            for (int i = 1; i < dp.length; i++) {
                if (dp[i-1] == (end-dp[i])) {
                    result = i - 1;
                    break;
                }
            }
            System.out.println(result);
        }
        input.close();
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(","))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static int[] getDp(int[] ints) {
        int[] dp = new int[ints.length+1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i-1] + ints[i-1];
        }
        return dp;
    }
}
