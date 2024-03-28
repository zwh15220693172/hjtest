package hjtest.leecode.前缀和;

import java.util.Arrays;

public class LeeCode1292 {

    public static void main(String[] args) {
        int[][] mat = {{1,1,3,2,4,3,2}, {1,1,3,2,4,3,2}, {1,1,3,2,4,3,2}};
        LeeCode1292 leeCode1292 = new LeeCode1292();
        System.out.println(leeCode1292.maxSideLength(mat, 4));
    }

    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dp = buildDp(m,n,mat);
        int maxLen = Math.min(m,n);
        for (int len = maxLen; len >= 1; len--) {
            for (int i = len; i <= m; i++) {
                for (int j = len; j <= n; j++) {
                    int cur = dp[i][j] - dp[i-len][j] - dp[i][j-len] + dp[i-len][j-len];
                    if (cur == threshold) {
                        return len;
                    }
                }
            }
        }
        return 0;
    }

    private int[][] buildDp(int m, int n, int[][] mat) {
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + mat[i-1][j-1];
            }
        }
        return dp;
    }
}
