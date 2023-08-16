package hjtest.B复100分.hj86玩牌高手;

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
            int[] dp = new int[ints.length];
            dp[0] = Math.max(0,ints[0]);
            for (int i = 1; i < dp.length; i++) {
                if (i < 3) {
                    dp[i] = Math.max(dp[i-1] + ints[i],0);
                } else {
                    dp[i] = Math.max(dp[i-1]+ints[i],dp[i-3]);
                }
            }
            System.out.println(dp[dp.length-1]);
        }
        input.close();
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(","))
                .mapToInt(Integer::parseInt).toArray();
    }
}
