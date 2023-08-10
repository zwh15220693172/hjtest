package hjtest.B卷200分.hj12周末爬山;

import java.util.Arrays;
import java.util.Scanner;

/**
 * bfs
 * 注意的事情是，需要使用一个boolean[][] used的矩阵来保存当次移动方向
 * 比如说，我从下面绕个圈过来要9步走完，也能获得最高的高度
 * 但是我从右边过去，只需要2步，因此回溯的时候
 * used[i][j] = true
 * backtracking();
 * used[i][j] = false
 * 没有100%有超时用例
 */
public class Main {
    private static int m;
    private static int n;
    private static int split;

    private static final int[][] directors = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };

    private static int result;

    private static int midLen;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] mnSplit = getInts(input.nextLine());
            m = mnSplit[0];
            n = mnSplit[1];
            split = mnSplit[2];
            int[][] grid = buildGrid(m,n,input);
            result = Integer.MIN_VALUE;
            midLen = Integer.MAX_VALUE;
            boolean[][] used = new boolean[m][n];
            used[0][0] = true;
            getResult(0,0,0,used,grid);
            System.out.println(result + " " + midLen);
        }
        input.close();
    }

    private static void getResult(int i, int j, int len, boolean[][] used, int[][] grid) {
        if (grid[i][j] > result) {
            result = grid[i][j];
            midLen = len;
        } else if (grid[i][j] == result) {
            midLen = Math.min(len,midLen);
        }
        for (int[] director : directors) {
            int x = i + director[0];
            int y = j + director[1];
            if (x < 0 || x >= m || y < 0 || y >= n) {
                continue;
            }
            if (used[x][y]) {
                continue;
            }
            if (Math.abs(grid[x][y]-grid[i][j]) > split) {
                continue;
            }
            used[x][y] = true;
            getResult(x,y,len+1,used,grid);
            used[x][y] = false;
        }
    }

    private static int[][] buildGrid(int m, int n, Scanner input) {
        int[][] grid = new int[m][n];
        int index = 0;
        while (index < m) {
            grid[index++] = Arrays.stream(input.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return grid;
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
