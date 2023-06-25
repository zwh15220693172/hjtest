package hjtest.A.hj15探索地块建立;

public class LeeCode1292 {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int maxLen = Math.min(m,n);
        int[][] dp = getDp(m,n,mat);
        for (int len = maxLen; len >= 1; len--) {
            for (int i = len; i <= m; i++) {
                for (int j = len; j <= n; j++) {
                    int cur = dp[i][j] - dp[i-len][j] - dp[i][j-len] + dp[i-len][j-len];
                    if (cur <= threshold) {
                        return len;
                    }
                }
            }
        }
        return 0;
    }

    private int[][] getDp(int m, int n, int[][] mat) {
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] + mat[i-1][j-1] - dp[i-1][j-1];
            }
        }
        return dp;
    }
}
