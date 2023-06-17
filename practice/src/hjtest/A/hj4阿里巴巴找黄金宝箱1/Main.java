package hjtest.A.hj4阿里巴巴找黄金宝箱1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] ints = getIns(input.nextLine());
            int result = getResult(ints);
            System.out.println(result);
        }
        input.close();
    }

    private static int getResult(int[] ints) {
        int[] dp = getDp(ints);
        int len = ints.length;
        for (int i = 1; i < dp.length; i++) {
            if (dp[i-1] == dp[len] - dp[i]) {
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

    private static int[] getIns(String nextLine) {
        return Arrays.stream(nextLine.split(","))
                .mapToInt(Integer::parseInt).toArray();
    }
}
