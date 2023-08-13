package hjtest.B卷200分.hj04代表团坐车;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 100%通过
 * 组成目标和有多少种方式
 * 我现在有ints[i]我组成dp[j]有dp[j-ints[i]]种方式
 * 我现在有ints[i+1]我组成dp[j]有dp[j-ints[i+1]]种方式
 * 因此dp[j]+=ints[i]
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] ints = getInts(input.nextLine());
            int target = Integer.parseInt(input.nextLine());
            int[] dp = new int[target+1];
            dp[0] = 1;
            for (int i = 0; i < ints.length; i++) {
                for (int j = target; j >= ints[i]; j--) {
                    dp[j] += dp[j-ints[i]];
                }
            }
            System.out.println(dp[target]);
        }
        input.close();
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(",")).mapToInt(Integer::parseInt).toArray();
    }
}
