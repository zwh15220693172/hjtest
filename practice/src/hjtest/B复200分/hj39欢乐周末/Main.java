package hjtest.B复200分.hj39欢乐周末;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        setGrid(m,n,grid,input);
        List<int[]> targetList = search(m,n,grid,3);
        List<int[]> peoples = search(m,n,grid,2);
        boolean[][] xiaoHuaCanMove = buildMove(peoples.get(0),grid,m,n);
        boolean[][] xiaoWeiCanMove = buildMove(peoples.get(1),grid,m,n);
        int count = 0;
        for (int[] target : targetList) {
            int x = target[0];
            int y = target[1];
            if (xiaoHuaCanMove[x][y] && xiaoWeiCanMove[x][y]) {
                count++;
            }
        }
        System.out.println(count);
    }

    private static boolean[][] buildMove(int[] ints, int[][] grid, int m, int n) {
        boolean[][] used = new boolean[m][n];
        backtracking(ints[0],ints[1],m,n,grid,used);
        return used;
    }

    private static void backtracking(int i, int j, int m, int n, int[][] grid, boolean[][] used) {
        used[i][j] = true;
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
            backtracking(x,y,m,n,grid,used);
        }
    }

    private static boolean getResult(int x, int y, int[] target, boolean[][] used, int[][] grid) {
        if (x == target[0] && y == target[1]) {
            return true;
        }

        return false;
    }

    private static List<int[]> search(int m, int n, int[][] grid, int value) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == value) {
                    list.add(new int[]{i,j});
                }
            }
        }
        return list;
    }

    private static void setGrid(int m, int n, int[][] grid, Scanner input) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = input.nextInt();
            }
        }
    }
}
