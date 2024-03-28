package hjtest.leecode.图论;

import java.util.LinkedList;

public class LeeCode994 {
    private static final int[][] directors = {{1,0},{-1,0},{0,1},{0,-1}};

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        LinkedList<int[]> badList = buildBadList(grid);
        int minute = 0;
        while (!badList.isEmpty()) {
            int size = badList.size();
            boolean haveChange = false;
            while (size > 0) {
                int[] bad = badList.pop();
                for (int[] director : directors) {
                    int x = bad[0] + director[0];
                    int y = bad[1] + director[1];
                    if (x < 0 || x >= m || y < 0 || y >= n) {
                        continue;
                    }
                    if (grid[x][y] == 0 || grid[x][y] == 2) {
                        continue;
                    }
                    haveChange = true;
                    grid[x][y] = 2;
                    badList.addLast(new int[]{x,y});
                }
                size--;
            }
            if (haveChange) {
                 minute++;
            }
        }
        return noFresh(grid) ? minute : -1;
    }

    private boolean noFresh(int[][] grid) {
        int n = grid[0].length;
        for (int[] ints : grid) {
            for (int j = 0; j < n; j++) {
                if (ints[j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private LinkedList<int[]> buildBadList(int[][] grid) {
        LinkedList<int[]> badList  = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    badList.addLast(new int[]{i,j});
                }
            }
        }
        return badList;
    }
}
