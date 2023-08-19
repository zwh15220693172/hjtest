package hjtest.B复200分.hj10污染水域;

import java.util.*;

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
            int n = (int)Math.sqrt(ints.length);
            int[][] grid = buildGrid(n,ints);
            if (allOne(n,grid)) {
                System.out.println(-1);
            } else {
                LinkedList<int[]> oneList = listOne(n,grid);
                int day = 0;
                while (!oneList.isEmpty()) {
                    int size = oneList.size();
                    while (size > 0) {
                        int[] cur = oneList.pop();
                        for (int[] director : directors) {
                            int x = director[0] + cur[0];
                            int y = director[1] + cur[1];
                            if (x < 0 || x >= n || y < 0 || y >= n) {
                                continue;
                            }
                            if (grid[x][y] != 0) {
                                continue;
                            }
                            grid[x][y] = 1;
                            oneList.addLast(new int[]{x,y});
                        }
                        size--;
                    }
                    if (oneList.size() > 0) {
                        day++;
                    }
                }
                if (haveZero(n,grid)) {
                    System.out.println(-1);
                } else {
                    System.out.println(day);
                }
            }
        }
        input.close();
    }

    private static boolean haveZero(int n, int[][] grid) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    private static LinkedList<int[]> listOne(int n, int[][] grid) {
        LinkedList<int[]> oneList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    oneList.add(new int[]{i,j});
                }
            }
        }
        return oneList;
    }

    private static boolean allOne(int n, int[][] grid) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int[][] buildGrid(int n, int[] ints) {
        int index = 0;
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = ints[index++];
            }
        }
        return grid;
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(","))
                .mapToInt(Integer::parseInt).toArray();
    }
}
