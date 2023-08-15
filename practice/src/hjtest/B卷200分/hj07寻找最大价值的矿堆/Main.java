package hjtest.B卷200分.hj07寻找最大价值的矿堆;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 100%通过
 * dfs，使用一个boolean[][]来记录走过了哪些区域
 * 因为可以先走左边，再走右边，因此有返回值返回
 */
public class Main {
    private static int m;
    private static int n;

    private static final int[][] directors = {
            {0,1},
            {0,-1},
            {1,0},
            {-1,0}
    };

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            List<String> command = listCommand(input);
            int[][] grid = buildGrid(command);
            m = grid.length;
            n = grid[0].length;
            boolean[][] used = new boolean[m][n];
            int result = Integer.MIN_VALUE;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!used[i][j] && (grid[i][j] == 1 || grid[i][j] == 2)) {
                        int cur = getResult(i,j,grid,used);
                        result = Math.max(cur,result);
                    }
                }
            }
            if (result == Integer.MIN_VALUE) {
                System.out.println(0);
            } else {
                System.out.println(result);
            }
        }
        input.close();
    }

    private static int getResult(int i, int j, int[][] grid, boolean[][] used) {
        int sum = grid[i][j];
        used[i][j] = true;
        for (int[] director : directors) {
            int x = i + director[0];
            int y = j + director[1];
            if (x < 0 || x >= m || y < 0 || y >= n) {
                continue;
            }
            if (!used[x][y] && (grid[x][y] == 1 || grid[x][y] == 2)) {
                sum += getResult(x,y,grid,used);
            }
        }
        return sum;
    }

    private static int[][] buildGrid(List<String> command) {
        int len = command.size();
        int[][] grid = new int[len][];
        int index = 0;
        while (index < len) {
            grid[index] = buildInt(command.get(index));
            index++;
        }
        return grid;
    }

    private static int[] buildInt(String inputStr) {
        return Arrays.stream(inputStr.split(""))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static List<String> listCommand(Scanner input) {
        List<String> listCommand = new ArrayList<>();
        while (true) {
            String nextLine = input.nextLine();
            if (nextLine.isEmpty()) {
                break;
            }
            listCommand.add(nextLine);
        }
        return listCommand;
    }
}
