package hjtest.B复200分.hj01最长广播效应;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextInt()) {
            int len = input.nextInt();
            int[][] grid = buildGrid(len);
            int count = input.nextInt();
            setGrid(count, grid, input);
            int start = input.nextInt() - 1;
            int[] dp = grid[start];
            boolean[] used = new boolean[len];
            used[start] = true;
            for (int i = 0; i < len; i++) {
                int next = -1;
                int weight = Integer.MAX_VALUE;
                for (int j = 0; j < dp.length; j++) {
                    if (!used[j] && dp[j] < weight) {
                        next = j;
                        weight = dp[j];
                    }
                }
                if (next == -1) {
                    break;
                }
                used[next] = true;
                int[] nextInts = grid[next];
                for (int k = 0; k < nextInts.length; k++) {
                    if (nextInts[k] != Integer.MAX_VALUE) {
                        int cur = nextInts[k] + weight;
                        dp[k] = Math.min(cur,dp[k]);
                    }
                }
            }
            int result = getResult(dp);
            System.out.println(result*2);
        }
        input.close();
    }

    private static int getResult(int[] dp) {
        return Arrays.stream(dp).max().getAsInt();
    }

    private static int[][] buildGrid(int len) {
        int[][] grid = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j) {
                    grid[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        return grid;
    }

    private static void setGrid(int count, int[][] grid, Scanner input) {
        while (count > 0) {
            int x = input.nextInt() - 1;
            int y = input.nextInt() - 1;
            grid[x][y] = 1;
            count--;
        }
    }
}
