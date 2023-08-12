package hjtest.B卷100分.hj06阿里巴巴的黄金宝箱;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 100%
 * 前缀和的运用
 * 之前箱子的和等于之后箱子的数量，左右都可以算为0
 * 1.初始化dp数组，dp[0]=0
 * 2.左边箱子为dp[i-1]
 * 3.右边箱子为dp[end]-dp[i]
 * 注意，dp的长度从1到dp.length-1，这样子就可以顾及到做左边右边和为0的情况
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
