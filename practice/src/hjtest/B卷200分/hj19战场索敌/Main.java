package hjtest.B卷200分.hj19战场索敌;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 元数据为grid[i][j]
 * 根据题目描述可知，通过#分割成了不同的区域
 * 整一个boolean[][] used用来记录走过的区域
 * dfs遍历，如果grid[i][j].equals("#")墙那么退出遍历
 * 如果为.那么要继续遍历
 * 如果为E，也要继续遍历，并且敌人数目sum要++
 * 100%通过
 */
public class Main {
    private static final int[][] directors = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };

    private static int m;
    private static int n;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] mnK = getInts(input.nextLine());
            m = mnK[0];
            n = mnK[1];
            int k = mnK[2];
            String[][] grid = buildGrid(input);
            boolean[][] used = new boolean[m][n];
            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j].equals("#") || used[i][j]) {
                        continue;
                    }
                    int cur = getCur(i,j,0,grid,used);
                    if (cur < k) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
        input.close();
    }

    private static int getCur(int i, int j, int sum, String[][] grid, boolean[][] used) {
        used[i][j] = true;
        if (grid[i][j].equals("E")) {
            sum++;
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
            if (grid[x][y].equals("#")) {
                continue;
            }
            sum = getCur(x,y,sum,grid,used);
        }
        return sum;
    }

    private static String[][] buildGrid(Scanner input) {
        String[][] grid = new String[m][n];
        int index = 0;
        while (index < m) {
            grid[index++] = input.nextLine().split("");
        }
        return grid;
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
