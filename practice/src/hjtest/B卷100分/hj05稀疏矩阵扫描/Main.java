package hjtest.B卷100分.hj05稀疏矩阵扫描;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 100%通过
 * 记录每一行0的数量，如果大于等于len / 2 ，那么count++
 * 记录每一列0的数量，如果大于等于len / 2，那么count++
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] mnInts = getInts(input.nextLine());
            int m = mnInts[0];
            int n = mnInts[1];
            int[][] grid = buildGrid(m,input);
            System.out.println(getM(grid,m,n));
            System.out.println(getN(grid,m,n));
        }
        input.close();
    }

    private static int getN(int[][] grid, int m, int n) {
        int count = 0;
        int target = m / 2;
        for (int i = 0; i < n; i++) {
            int zeroCount = 0;
            for (int j = 0; j < m; j++) {
                if (grid[j][i] == 0) {
                    zeroCount++;
                }
            }
            if (zeroCount >= target) {
                count++;
            }
        }
        return count;
    }

    private static int getM(int[][] grid, int m, int n) {
        int count = 0;
        int target = n / 2;
        for (int i = 0; i < m; i++) {
            int zeroCount = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    zeroCount++;
                }
            }
            if (zeroCount >= target) {
                count++;
            }
        }
        return count;
    }

    private static int[][] buildGrid(int m, Scanner input) {
        int[][] grid = new int[m][];
        int index = 0;
        while (index < m) {
            grid[index++] = Arrays.stream(input.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return grid;
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
