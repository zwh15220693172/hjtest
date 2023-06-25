package hjtest.A.hj15探索地块建立;

public class LeeCode1277 {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxLen = Math.min(m,n);
        int count = 0;
        int[][] dp = getDp(m,n,matrix);
        for (int len = 1; len <= maxLen; len++) {
            int target = len * len;
            for (int i = len; i <= m; i++) {
                for (int j = len; j <= n; j++) {
                    int cur = dp[i][j] - dp[i-len][j] - dp[i][j-len] + dp[i-len][j-len];
                    if (cur == target) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private int[][] getDp(int m, int n, int[][] matrix) {
        int[][] dp = new int[m+1][n+1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] + matrix[i-1][j-1] - dp[i-1][j-1];
            }
        }
        return dp;
    }
}
