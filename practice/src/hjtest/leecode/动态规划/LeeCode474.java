package hjtest.leecode.动态规划;

public class LeeCode474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] ints = buildInts(strs);
        int[][] grid = new int[m+1][n+1];
        for (int[] cur : ints) {
            int zeroCount = cur[0];
            int oneCount = cur[1];
            for (int i = m; i >= zeroCount; i--) {
                for (int j = n; j >= oneCount; j--) {
                    grid[i][j] = Math.max(grid[i][j],grid[i-zeroCount][j-oneCount]+1);
                }
            }
        }
        return grid[m][n];
    }

    private int[][] buildInts(String[] strs) {
        int[][] ints = new int[strs.length][2];
        for (int i = 0; i < strs.length; i++) {
            int oneCount = 0;
            int zeroCount = 0;
            String str = strs[i];
            char[] chars = str.toCharArray();
            for (char aChar : chars) {
                if (aChar == '0') {
                    zeroCount++;
                } else {
                    oneCount++;
                }
            }
            ints[i] = new int[]{zeroCount,oneCount};
        }
        return ints;
    }
}
