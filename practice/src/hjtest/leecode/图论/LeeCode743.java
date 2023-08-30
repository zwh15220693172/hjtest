package hjtest.leecode.图论;

public class LeeCode743 {

    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] grid = buildGrid(n);
        setGrid(grid,times);
        int[] dp = grid[k-1];
        boolean[] used = new boolean[dp.length];
        used[k-1] = true;
        for (int i = 0; i < n; i++) {
            int next = -1;
            int weight = Integer.MAX_VALUE;
            for (int j = 0; j < dp.length; j++) {
                if (!used[j] && dp[j] < weight) {
                    weight = dp[j];
                    next = j;
                }
            }
            if (next == -1) {
                break;
            }
            used[next] = true;
            int[] nextInts = grid[next];
            for (int z = 0; z < nextInts.length; z++) {
                if (nextInts[z] != Integer.MAX_VALUE) {
                    int cur = nextInts[z] + weight;
                    dp[z] = Math.min(cur,dp[z]);
                }
            }
        }
        int max = getMax(dp);
        return max == Integer.MAX_VALUE ? -1 : max;
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

    private int getMax(int[] dp) {
        int max = Integer.MIN_VALUE;
        for (int cur : dp) {
            max = Math.max(cur,max);
        }
        return max;
    }

    private void setGrid(int[][] grid, int[][] times) {
        for (int[] time : times) {
            int x = time[0] - 1;
            int y = time[1] - 1;
            int weight = time[2];
            grid[x][y] = weight;
        }
    }
}
