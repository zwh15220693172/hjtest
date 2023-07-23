package hjtest.C.Demo02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            char[] commands = input.nextLine().toCharArray();
            List<int[]> barList = barList(input.nextLine());
            int x = Integer.parseInt(input.nextLine());
            int y = Integer.parseInt(input.nextLine());
            int[][] grid = new int[x+1][y+1];
            setBar(grid,barList);
            boolean result = getResult(commands, grid, x, y);
        }
        input.close();
    }

    private static boolean getResult(char[] commands, int[][] grid, int endX, int endY) {
        int x = 0;
        int y = 0;
        for (char command : commands) {
            if (command == 'U') {
                if (x < endX) {
                    x = x + 1;
                }
            } else if (command == 'U') {
                if (x > 0) {
                    x = x - 1;
                }
            } else if (command == 'Y') {
                if (y < endY) {
                    y = y + 1;
                }
            } else {
                if (y > 0) {
                    y = y - 1;
                }
            }
            if (grid[x][y] == -1) {
                break;
            }
        }
        return x == endX && y == endY;
    }

    private static void setBar(int[][] grid, List<int[]> barList) {
        for (int[] ints : barList) {
            int x = ints[0];
            int y = ints[1];
            grid[x][y] = -1;
        }
    }

    private static List<int[]> barList(String nextLine) {
        String substring = nextLine.substring(1, nextLine.length() - 1);
        String[] splits = substring.split(",");
        List<int[]> list = new ArrayList<>();
        for (String split : splits) {
            String number = split.substring(1, split.length() - 1);
            String[] nums = number.split(",");
            int x = Integer.parseInt(nums[0]);
            int y = Integer.parseInt(nums[1]);
            list.add(new int[]{x,y});
        }
        return list;
    }
}
