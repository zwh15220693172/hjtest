package hjtest.A.hj15探索地块建立;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] params = getParam(input.nextLine());
            int m = params[0];
            int n = params[1];
            int len = params[2];
            int target = params[3];
            int[][] ints = getInts(m,n,input);
            int[][] dp = getDp(m,n, ints);
            int count = 0;
            for (int i = len; i <= m; i++) {
                for (int j = len; j <= n; j++) {
                    int cur = dp[i][j] - dp[i-len][j] - dp[i][j-len] + dp[i-len][j-len];
                    if (cur >= target) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
        input.close();
    }

    private static int[][] getDp(int m, int n, int[][] ints) {
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] + ints[i-1][j-1] - dp[i-1][j-1];
            }
        }
        return dp;
    }

    private static int[][] getInts(int m, int n, Scanner input) {
        int[][] ints = new int[m][n];
        int index = 0;
        while (index < m) {
            ints[index++] = Arrays.stream(input.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return ints;
    }

    private static int[] getParam(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
