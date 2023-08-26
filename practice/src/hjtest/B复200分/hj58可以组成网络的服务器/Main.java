package hjtest.B复200分.hj58可以组成网络的服务器;

import java.util.Scanner;

/**
 * 100%通过
 */
public class Main {
    private static final int[][] directors = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        int[][] grid = new int[m][n];
        initGrid(m,n,grid,input);
        boolean[][] used = new boolean[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !used[i][j]) {
                    int count = backtracking(i,j,m,n,grid,used);
                    max = Math.max(count,max);
                }
            }
        }
        System.out.println(max);
    }

    private static int backtracking(int i, int j, int m, int n, int[][] grid, boolean[][] used) {
        used[i][j] = true;
        int cur = 1;
        for (int[] director : directors) {
            int x = director[0] + i;
            int y = director[1] + j;
            if (x < 0 || x >= m || y < 0 || y >= n) {
                continue;
            }
            if (used[x][y]) {
                continue;
            }
            if (grid[x][y] == 1) {
                cur+=backtracking(x,y,m,n,grid,used);
            }
        }
        return cur;
    }

    private static void initGrid(int m, int n, int[][] grid, Scanner input) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = input.nextInt();
            }
        }
    }
}
