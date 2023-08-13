package hjtest.B卷200分.hj27矩阵中非1的元素个数;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 100%通过
 * dfs遍历即可
 */
public class Main {
    private static final int[][] directors = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1},
    };

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] params = getInts(input.nextLine());
            int m = params[0];
            int n = params[1];
            int[][] grid = buildGrid(m,n,input);
            grid[0][0] = 1;
            LinkedList<int[]> startList = new LinkedList<>();
            startList.add(new int[]{0,0});
            while (!startList.isEmpty()) {
                int[] cur = startList.poll();
                for (int[] director : directors) {
                    int x = cur[0] + director[0];
                    int y = cur[1] + director[1];
                    if (x < 0 || x >= m || y < 0 || y >= n) {
                        continue;
                    }
                    if (grid[x][y] != 0) {
                        continue;
                    }
                    grid[x][y] = 1;
                    startList.add(new int[]{x,y});
                }
            }
            int count = checkNotOne(m,n,grid);
            System.out.println(count);
        }
        input.close();
    }

    private static int checkNotOne(int m, int n, int[][] grid) {
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 1) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int[][] buildGrid(int m, int n, Scanner input) {
        int[][] grid = new int[m][n];
        int index = 0;
        while (index < m) {
            grid[index++] = getInts(input.nextLine());
        }
        return grid;
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
