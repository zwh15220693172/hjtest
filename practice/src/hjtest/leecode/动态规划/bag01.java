package hjtest.leecode.动态规划;

import java.util.Arrays;

public class bag01 {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWight = 4;
        testWeightBagProblem(weight, value, bagWight);
    }

    private static void testWeightBagProblem(int[] weight, int[] value, int bagWight) {
        int[] dp = new int[bagWight+1];
        for (int i = 0; i < weight.length; i++) {
            for (int j = dp.length - 1; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j],dp[j-weight[i]]+value[i]);
            }
        }
        System.out.println(Arrays.toString(dp));
    }
}
