package hjtest.leecode.图论;

public class LeeCode743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] grid = buildGrid(n);
        setGrid(times, grid);
        int start = k - 1;
        int[] dp = grid[start];
        boolean[] used = new boolean[n];
        used[start] = true;
        for (int i = 0; i < n; i++) {
            int next = -1;
            int weight = Integer.MAX_VALUE;
            for (int j = 0; j < dp.length; j++) {
                if (!used[j] && dp[j] < weight) {
                    next = j;
                    weight = dp[j];
                }
            }
            if (next == -1) {
                break;
            }
            used[next] = true;
            int[] ints = grid[next];
            for (int z = 0; z < ints.length; z++) {
                if (ints[z] != Integer.MAX_VALUE) {
                    int cur = ints[z] + weight;
                    dp[z] = Math.min(cur,dp[z]);
                }
            }
        }
        return getResult(dp);
    }

    private int getResult(int[] dp) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(dp[i],max);
        }
        return max == Integer.MAX_VALUE ? -1 : max;
    }

    private void setGrid(int[][] times, int[][] grid) {
        for (int[] time : times) {
            int x = time[0] - 1;
            int y = time[1] - 1;
            int weight = time[2];
            grid[x][y] = weight;
        }
    }

    private int[][] buildGrid(int n) {
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    grid[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        return grid;
    }
}
