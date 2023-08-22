package hjtest.B复200分.hj21字符串比较;

import java.util.Scanner;

/**
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            char[] chars01 = input.nextLine().toCharArray();
            char[] chars02 = input.nextLine().toCharArray();
            int k = Integer.parseInt(input.nextLine());
            int len = chars01.length;
            int[] ints = new int[len];
            for (int i = 0; i < len; i++) {
                int cur = Math.abs(chars01[i]-chars02[i]);
                ints[i] = cur;
            }
            int[] dp = getDp(len,ints);
            int max = 0;
            for (int i = 0; i < dp.length; i++) {
                for (int j = i+1; j < dp.length; j++) {
                    int cur = dp[j] - dp[i];
                    if (cur > k) {
                        break;
                    }
                    max = Math.max(j-i,max);
                }
            }
            System.out.println(max);
        }
        input.close();
    }

    private static int[] getDp(int len, int[] ints) {
        int[] dp = new int[len+1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i-1]+ints[i-1];
        }
        return dp;
    }
}
