package hjtest.leecode.动态规划;

import java.util.Arrays;

public class bag02 {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;
        backtracking(weight,value,bagWeight);
    }

    private static void backtracking(int[] weight, int[] value, int bagWeight) {
        int[] dp = new int[bagWeight+1];
        for (int i = 0; i < weight.length; i++) {
            for (int j = weight[i]; j <= bagWeight; j++) {
                dp[j] = Math.max(dp[j],dp[j-weight[i]]+value[i]);
            }
        }
        System.out.println(Arrays.toString(dp));
    }
}
