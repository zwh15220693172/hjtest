package hjtest.宜居星球改造计划;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final int[][] directors = {
            {1,0},{-1,0},{0,1},{0,-1}
    };

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String> commands = new ArrayList<>();
        while (input.hasNextLine()) {
            String inputStr = input.nextLine();
            if (inputStr.isEmpty()) {
                break;
            }
            commands.add(inputStr);
        }
        String[][] grid = buildGrid(commands);
        LinkedList<int[]> listYes = listYes(grid);
        int days = 0;
        while (!listYes.isEmpty()) {
            int size = listYes.size();
            boolean haveChange = false;
            while (size > 0) {
                int[] cur = listYes.pop();
                for (int[] director : directors) {
                    int x = cur[0] + director[0];
                    int y = cur[1] + director[1];
                    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
                        continue;
                    }
                    if ("NO".equals(grid[x][y])) {
                        haveChange = true;
                        grid[x][y] = "YES";
                        listYes.add(new int[]{x,y});
                    }
                }
                size--;
            }
            if (haveChange) {
                days++;
            }
        }
        if (allYes(grid)) {
            System.out.println(days);
        } else {
            System.out.println(-1);
        }
        input.close();
    }

    private static boolean allYes(String[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!"YES".equals(grid[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    private static LinkedList<int[]> listYes(String[][] grid) {
        LinkedList<int[]> listYes = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if ("YES".equals(grid[i][j])) {
                    listYes.add(new int[]{i,j});
                }
            }
        }
        return listYes;
    }

    private static String[][] buildGrid(List<String> commands) {
        String[][] grid = new String[commands.size()][];
        int index = 0;
        for (String command : commands) {
            grid[index++] = command.split(" ");
        }
        return grid;
    }
}
