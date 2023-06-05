package hjtest.B.hj10寻找最大价值的矿堆;

import sun.java2d.windows.GDIRenderer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final int[][] directors = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1},
    };

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String> commands = new ArrayList<>();
        while (input.hasNextLine()) {
            String command = input.nextLine();
            if (command.isEmpty()) {
                break;
            }
            commands.add(command);
        }
        int[][] grid = buildGrid(commands);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 1 && grid[i][j] != 2) {
                    continue;
                }
                max = Math.max(getResult(grid, i, j,0), max);
            }
        }
        System.out.println(max);
        input.close();
    }

    private static int getResult(int[][] grid, int i, int j, int sum) {
        if (grid[i][j] != 1 && grid[i][j] != 2) {
            return sum;
        }
        sum += grid[i][j];
        grid[i][j] = 0;
        for (int[] director : directors) {
            int x = i + director[0];
            int y = j + director[1];
            if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
                continue;
            }
            sum = getResult(grid,x,y,sum);
        }
        return sum;
    }

    private static int[][] buildGrid(List<String> commands) {
        int[][] grid = new int[commands.size()][];
        for (int i = 0; i < commands.size(); i++) {
            grid[i] = Arrays.stream(commands.get(i).split(""))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return grid;
    }
}
