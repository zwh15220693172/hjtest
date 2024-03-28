package hjtest.leecode.图论;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeeCode417 {
    private static final int[][] directors = {{1,0},{-1,0},{0,1},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] canPacific = canPacific(m,n,heights);
        boolean[][] canAtlantic = canAtlantic(m,n,heights);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canAtlantic[i][j] && canPacific[i][j]) {
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }

    private boolean[][] canAtlantic(int m, int n, int[][] heights) {
        int[][] path = new int[m][n];
        boolean[][] canAtlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canAtlantic[i][j]) {
                    continue;
                }
                atlanticBacktracking(i,j,m,n,path,heights,canAtlantic);
            }
        }
        return canAtlantic;
    }

    private boolean atlanticBacktracking(int i, int j, int m, int n, int[][] path, int[][] heights, boolean[][] canAtlantic) {
        path[i][j] = 1;
        for (int[] director : directors) {
            int x = i + director[0];
            int y = j + director[1];
            if (x < 0 || y < 0) {
                continue;
            }
            if (x >= m || y >= n) {
                canAtlantic[i][j] = true;
                path[i][j] = 0;
                return true;
            }
            if (path[x][y] == 1) {
                continue;
            }
            if (heights[i][j] < heights[x][y]) {
                continue;
            }
            if (atlanticBacktracking(x,y,m,n,path,heights,canAtlantic)) {
                canAtlantic[i][j] = true;
                path[i][j] = 0;
                return true;
            }
        }
        path[i][j] = 0;
        return false;
    }

    private boolean[][] canPacific(int m, int n, int[][] heights) {
        int[][] path = new int[m][n];
        boolean[][] canPacific = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canPacific[i][j]) {
                    continue;
                }
                pacificBacktracking(i,j,m,n,path,heights,canPacific);
            }
        }
        return canPacific;
    }

    private boolean pacificBacktracking(int i, int j, int m, int n, int[][] path, int[][] heights, boolean[][] canPacific) {
        path[i][j] = 1;
        for (int[] director : directors) {
            int x = i + director[0];
            int y = j + director[1];
            if (x < 0 || y < 0) {
                canPacific[i][j] = true;
                path[i][j] = 0;
                return true;
            }
            if (x >= m || y >= n) {
                continue;
            }
            if (path[x][y] == 1) {
                continue;
            }
            if (heights[i][j] < heights[x][y]) {
                continue;
            }
            if (pacificBacktracking(x,y,m,n,path,heights,canPacific)) {
                canPacific[i][j] = true;
                path[i][j] = 0;
                return true;
            }
        }
        path[i][j] = 0;
        return false;
    }
}
