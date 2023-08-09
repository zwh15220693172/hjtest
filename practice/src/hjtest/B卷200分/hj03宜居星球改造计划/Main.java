package hjtest.B卷200分.hj03宜居星球改造计划;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 输出改造天数的条件
 * 1.改造天数>0
 * 2.grid内已经没有no了
 * 3.考虑一开始没有可改造区的情况
 */
public class Main {
    private static final int[][] director = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<String> commands = buildCommand(input);
        String[][] grid = buildGrid(commands);
        // 一开始就没有可改造区
        if (notNo(grid)) {
            System.out.println(0);
            // 有可改造区的情况
        } else {
            int m = grid.length;
            int n = grid[0].length;
            LinkedList<int[]> listYes = listYes(grid);
            int day = 0;
            while (!listYes.isEmpty()) {
                int size = listYes.size();
                while (size > 0) {
                    int[] cur = listYes.pop();
                    for (int[] ints : director) {
                        int x = ints[0] + cur[0];
                        int y = ints[1] + cur[1];
                        if (x < 0 || x >= m || y < 0 || y >= n) {
                            continue;
                        }
                        if (!("NO".equals(grid[x][y]))) {
                            continue;
                        }
                        grid[x][y] = "YES";
                        listYes.add(new int[]{x,y});
                    }
                    size--;
                }
                if (listYes.size() > 0) {
                    day++;
                }
            }
            if (notNo(grid) && day > 0) {
                System.out.println(day);
            } else {
                System.out.println(-1);
            }
        }

    }

    private static boolean notNo(String[][] grid) {
        for (String[] strings : grid) {
            for (int j = 0; j < strings.length; j++) {
                if ("NO".equals(strings[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    private static LinkedList<int[]> listYes(String[][] grid) {
        LinkedList<int[]> list = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if ("YES".equals(grid[i][j])) {
                    list.add(new int[]{i,j});
                }
            }
        }
        return list;
    }

    private static List<String> buildCommand(Scanner input) {
        List<String> commands = new ArrayList<>();
        while (input.hasNextLine()) {
            String inputStr = input.nextLine();
            if (inputStr.isEmpty()) {
                break;
            }
            commands.add(inputStr);
        }
        return commands;
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
