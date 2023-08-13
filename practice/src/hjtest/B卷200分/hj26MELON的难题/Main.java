package hjtest.B卷200分.hj26MELON的难题;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 100%通过
 * 组成对应目标target有多少种方式的题
 * Arrays.fill(dp,Integer.MAX_VALUE);
 * dp[0] = 0
 * 我的理解是
 * dp[i] = Math.min(dp[j],dp[i-ints[j]+1);
 * 因为下面有1了，不需要初始化dp[0]=1去进行地推，因此初始化为dp[0]=0
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int len = Integer.parseInt(input.nextLine());
            int[] ints = getInts(input.nextLine());
            int sum = Arrays.stream(ints).sum();
            if (sum % 2 != 0) {
                System.out.println(-1);
            } else {
                int target = sum / 2;
                int[] dp = new int[target+1];
                Arrays.fill(dp,Integer.MAX_VALUE);
                dp[0] = 0;
                for (int i = 0; i < ints.length; i++) {
                    for (int j = target; j >= ints[i]; j--) {
                        if (dp[j-ints[i]] != Integer.MAX_VALUE) {
                            dp[j] = Math.min(dp[j],dp[j-ints[i]]+1);
                        }
                    }
                }
                if (dp[target] == Integer.MAX_VALUE) {
                    System.out.println(-1);
                } else {
                    System.out.println(dp[target]);
                }
            }
        }
        input.close();
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
