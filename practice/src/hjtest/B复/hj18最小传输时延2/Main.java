package hjtest.B复.hj18最小传输时延2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int result;
    private static int m;
    private static int n;

    private static final int[][] directors = {
            {0,1},
            {1,1},
            {1,0},
            {1,-1},
            {0,-1}
    };

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            result = Integer.MAX_VALUE;
            int[] params = getParams(input.nextLine());
            m = params[0];
            n = params[1];
            int[][] grid = buildGrid(input);
            boolean[][] visit = new boolean[m][n];
            visit[0][0] = true;
            getResult(0,0,grid[0][0],grid[0][0],grid,visit);
            System.out.println(result);
        }
        input.close();
    }

    private static void getResult(int i, int j, int sum, int weight, int[][] grid, boolean[][] visit) {
        if (i == m - 1 && j == n - 1) {
            result = Math.min(sum, result);
            return;
        }
        for (int[] director : directors) {
            int x = director[0] + i;
            int y = director[1] + j;
            if (x < 0 || x >= m || y < 0 || y >= n) {
                continue;
            }
            if (visit[x][y]) {
                continue;
            }
            visit[x][y] = true;
            if (grid[x][y] == weight && weight != 0) {
                getResult(x,y,sum + grid[x][y] - 1, grid[x][y], grid,visit);
            } else {
                getResult(x,y,sum + grid[x][y], grid[x][y], grid,visit);
            }
            visit[x][y] = false;
        }
    }

    private static int[][] buildGrid(Scanner input) {
        int[][] grid = new int[m][n];
        int index = 0;
        while (index < m) {
            grid[index++] = Arrays.stream(input.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return grid;
    }

    private static int[] getParams(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
