package hjtest.B复200分.hj35机器人走迷宫;

import java.util.Scanner;

/**
 * 2道超时
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        int size = input.nextInt();
        int[][] grid = buildGrid(m,n,size,input);
        move(0,0,m,n,grid);
        int badCount = 0;
        int neverCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == -1) {
                    badCount++;
                } else if (grid[i][j] == 0) {
                    neverCount++;
                }
            }
        }
        System.out.println(badCount + " " + neverCount);
    }

    private static boolean move(int x, int y, int m, int n, int[][] grid) {
        if (x < 0 || y < 0 || x >= m || y >= n) {
            return false;
        }
        if (grid[x][y] == 1) {
            return false;
        }
        if (x == m - 1 && y == n - 1) {
            grid[x][y] = 2;
            return true;
        }
        boolean moveUp = move(x+1,y,m,n,grid);
        boolean moveRight = move(x,y+1,m,n,grid);
        if (moveUp || moveRight) {
            grid[x][y] = 2;
            return true;
        } else {
            grid[x][y] = -1;
            return false;
        }
    }

    private static int[][] buildGrid(int m, int n, int count, Scanner input) {
        int[][] grid = new int[m][n];
        while (count > 0) {
            int x = input.nextInt();
            int y = input.nextInt();
            grid[x][y] = 1;
            count--;
        }
        return grid;
    }
}
