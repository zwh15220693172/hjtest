package hjtest.B复200分.hj42迷宫问题;

import java.util.*;

/**
 * 100%通过
 */
public class Main {
    private static int min;
    private static final List<int[]> result = new ArrayList<>();

    private static final int[][] directors = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        min = Integer.MAX_VALUE;
        result.clear();
        int m = input.nextInt();
        int n = input.nextInt();
        int[][] grid = buildGrid(m,n,input);
        boolean[][] used = new boolean[m][n];
        used[0][0] = true;
        LinkedList<int[]> path = new LinkedList<>();
        path.addLast(new int[]{0,0});
        backtracking(0,0,used,grid,m,n,path);
        result.forEach((cur)-> System.out.println("("+cur[0]+","+cur[1]+")"));
    }

    private static void backtracking(int i, int j, boolean[][] used, int[][] grid,
                                     int m, int n, LinkedList<int[]> path) {
        if (i == m - 1 && j == n - 1) {
            if (path.size() < min) {
                result.clear();
                result.addAll(path);
                min = path.size();
            }
            return;
        }
        for (int[] director : directors) {
            int x = i + director[0];
            int y = j + director[1];
            if (x < 0 || x >= m || y < 0 || y >= n) {
                continue;
            }
            if (grid[x][y] == 1) {
                continue;
            }
            if (used[x][y]) {
                continue;
            }
            used[x][y] = true;
            path.addLast(new int[]{x,y});
            backtracking(x,y,used,grid,m,n,path);
            path.removeLast();
            used[x][y] = false;
        }
    }

    private static int[][] buildGrid(int m, int n, Scanner input) {
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = input.nextInt();
            }
        }
        return grid;
    }
}
