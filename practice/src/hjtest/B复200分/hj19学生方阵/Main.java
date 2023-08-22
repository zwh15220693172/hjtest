package hjtest.B复200分.hj19学生方阵;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 100%通过
 */
public class Main {
    private static final int[][] directors = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1},
            {1,1},
            {1,-1},
            {-1,1},
            {-1,-1}
    };

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] params = getInts(input.nextLine());
            int m = params[0];
            int n = params[1];
            String[][] grid = buildGrid(m,n,input);
            int max = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!"M".equals(grid[i][j])) {
                        continue;
                    }
                    for (int[] director : directors) {
                        int cur = backtracking(1,director,i,j,m,n,grid);
                        max = Math.max(cur,max);
                    }
                }
            }
            System.out.println(max);
        }
        input.close();
    }

    private static int backtracking(int cur, int[] director, int i, int j, int m, int n, String[][] grid) {
        int x = director[0] + i;
        int y = director[1] + j;
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return cur;
        }
        if (!grid[x][y].equals("M")) {
            return cur;
        }
        return backtracking(cur+1,director,x,y,m,n,grid);
    }

    private static String[][] buildGrid(int m, int n, Scanner input) {
        String[][] grid = new String[m][n];
        int index = 0;
        while (index < m) {
            grid[index++] = input.nextLine().split(",");
        }
        return grid;
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(","))
                .mapToInt(Integer::parseInt).toArray();
    }
}
