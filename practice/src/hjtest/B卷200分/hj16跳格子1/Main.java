package hjtest.B卷200分.hj16跳格子1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 100%通过
 * 打家劫舍1，注意的事情是当数组长度为1的情况
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] ints = getInts(input.nextLine());
            if (ints.length == 1) {
                System.out.println(ints[0]);
            } else {
                int[] dp = new int[ints.length];
                int len = ints.length;
                dp[0] = ints[0];
                dp[1] = Math.max(ints[0], ints[1]);
                for (int i = 2; i < dp.length; i++) {
                    dp[i] = Math.max(dp[i-1],dp[i-2]+ints[i]);
                }
                System.out.println(Math.max(dp[len-1],dp[len-2]));
            }
        }
        input.close();
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
