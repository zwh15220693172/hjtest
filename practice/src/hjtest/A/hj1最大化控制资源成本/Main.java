package hjtest.A.hj1最大化控制资源成本;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int m = Integer.parseInt(input.nextLine());
            int[][] grid = getGrid(m, input);
            sort(grid);
            int max = 0;
            for (int i = 0; i < grid.length; i++) {
                int curMax = grid[i][2];
                int right = grid[i][1];
                for (int j = i + 1; j < grid.length; j++) {
                    int left = grid[j][0];
                    if (left < right) {
                        curMax += grid[j][2];
                    }
                }
                max = Math.max(max, curMax);
            }
            System.out.println(max);
        }
        input.close();
    }

    private static void sort(int[][] grid) {
        Arrays.sort(grid, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] == b[1]) {
                    return a[0] - b[0];
                } else {
                    return a[1] - b[1];
                }
            }
        });
    }

    private static int[][] getGrid(int m, Scanner input) {
        int[][] grid = new int[m][];
        int index = 0;
        while (index < m) {
            grid[index++] = Arrays.stream(input.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return grid;
    }
}
