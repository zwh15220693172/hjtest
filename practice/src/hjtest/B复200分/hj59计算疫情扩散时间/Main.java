package hjtest.B复200分.hj59计算疫情扩散时间;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 100%通过
 */
public class Main {
    private static final int[][] directors = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] ints = getInts(input.nextLine());
            if (error(ints)) {
                System.out.println(-1);
            } else {
                int[][] grid = buildGrid(ints);
                int m = grid.length;
                int n = grid[0].length;
                LinkedList<int[]> oneList = searchOne(m,n,grid);
                int day = 0;
                while (!oneList.isEmpty()) {
                    int size = oneList.size();
                    while (size > 0) {
                        int[] cur = oneList.poll();
                        for (int[] director : directors) {
                            int x = director[0] + cur[0];
                            int y = director[1] + cur[1];
                            if (x < 0 || x >= m || y < 0 || y >= n) {
                                continue;
                            }
                            if (grid[x][y] == 0) {
                                grid[x][y] = 1;
                                oneList.addLast(new int[]{x,y});
                            }
                        }
                        size--;
                    }
                    if (oneList.size() > 0) {
                        day++;
                    }
                }
                System.out.println(day);
            }
        }
    }

    private static LinkedList<int[]> searchOne(int m, int n, int[][] grid) {
        LinkedList<int[]> list = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    list.addLast(new int[]{i,j});
                }
            }
        }
        return list;
    }

    private static int[][] buildGrid(int[] ints) {
        int n = (int)Math.sqrt(ints.length);
        int[][] grid = new int[n][n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = ints[index++];
            }
        }
        return grid;
    }

    private static boolean error(int[] ints) {
        int[] check = new int[ints.length];
        Arrays.fill(check,1);
        boolean allOne = Arrays.equals(check, ints);
        if (allOne) {
            return true;
        }
        Arrays.fill(check,0);
        return Arrays.equals(check, ints);
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(","))
                .mapToInt(Integer::parseInt).toArray();
    }
}
