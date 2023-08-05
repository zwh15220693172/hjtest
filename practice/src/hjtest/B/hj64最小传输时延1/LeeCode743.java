package hjtest.B.hj64最小传输时延1;

import java.util.Arrays;

public class LeeCode743 {

    public static void main(String[] args) {
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] grid = buildGrid(n);
        initGrid(grid,times);
        int start = k - 1;
        boolean[] used = new boolean[n];
        used[start] = true;
        int[] dp = grid[start];
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
            for (int l = 0; l < ints.length; l++) {
                if (ints[l] == Integer.MAX_VALUE) {
                    continue;
                }
                dp[l] = Math.min(dp[l],ints[l]+weight);
            }
        }
        return getResult(dp);
    }

    private int getResult(int[] dp) {
        int max = Integer.MIN_VALUE;
        for (int cur : dp) {
            max = Math.max(cur,max);
        }
        return max == Integer.MAX_VALUE ? -1 : max;
    }

    private void initGrid(int[][] grid, int[][] times) {
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
