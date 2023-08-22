package hjtest.B复200分.hj20发广播;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String[] strings = input.nextLine().split(",");
            int[][] grid = buildGrid(strings);
            int len = grid.length;
            boolean[] used = new boolean[len];
            int count = 0;
            for (int i = 0; i < len; i++) {
                if (!used[i]) {
                    backtracking(i,used,grid);
                    count++;
                }
            }
            System.out.println(count);
        }
        input.close();
    }

    private static void backtracking(int index, boolean[] used, int[][] grid) {
        used[index] = true;
        int next = findNext(index,used, grid);
        while (next != -1) {
            backtracking(next,used,grid);
            next = findNext(next,used,grid);
        }
    }

    private static int findNext(int index, boolean[] used, int[][] grid) {
        int[] ints = grid[index];
        for (int i = 0; i < used.length; i++) {
            if (!used[i] && ints[i] == 1) {
                return i;
            }
        }
        return -1;
    }

    private static int[][] buildGrid(String[] strings) {
        int[][] grid = new int[strings.length][];
        for (int i = 0; i < strings.length; i++) {
            grid[i] = Arrays.stream(strings[i].split(""))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return grid;
    }
}
