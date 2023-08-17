package hjtest.B复200分.hj05最小传输时延;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextInt()) {
            int len = input.nextInt();
            int count = input.nextInt();
            int[][] grid = buildGrid(len);
            setGrid(count,input,grid);
            int start = input.nextInt() - 1;
            int end = input.nextInt() - 1;
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
                int[] nextInts = grid[next];
                for (int l = 0; l < nextInts.length; l++) {
                    if (nextInts[l] != Integer.MAX_VALUE) {
                        int cur = nextInts[l] + weight;
                        dp[l] = Math.min(cur,dp[l]);
                    }
                }
            }
            System.out.println(dp[end]);
        }
        input.close();
    }

    private static void setGrid(int count, Scanner input, int[][] grid) {
        while (count > 0) {
            int x = input.nextInt() - 1;
            int y = input.nextInt() - 1;
            int weight = input.nextInt();
            grid[x][y] = weight;
            count--;
        }
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
}
