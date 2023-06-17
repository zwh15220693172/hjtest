package hjtest.B.hj17稀疏矩阵;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] mnInts = Arrays.stream(input.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int m = mnInts[0];
            int n = mnInts[1];
            int[][] grid = getGrid(m,n,input);
            int mCount = getMCount(m,n,grid);
            int nCount = getNCount(m,n,grid);
            System.out.println(mCount);
            System.out.println(nCount);
        }
        input.close();
    }

    private static int getNCount(int m, int n, int[][] grid) {
        int nCount = 0;
        int target = m / 2;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < m; j++) {
                if (grid[j][i] == 0) {
                    count++;
                }
            }
            if (count >= target) {
                nCount++;
            }
        }
        return nCount;
    }

    private static int getMCount(int m, int n, int[][] grid) {
        int target = n / 2;
        int mCount = 0;
        for (int i = 0; i < m; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    count++;
                }
            }
            if (count >= target) {
                mCount++;
            }
        }
        return mCount;
    }

    private static int[][] getGrid(int m, int n, Scanner input) {
        int[][] grid = new int[m][n];
        int index = 0;
        while (index < m) {
            grid[index++] = Arrays.stream(input.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return grid;
    }
}
