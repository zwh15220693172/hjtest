package hjtest.B卷100分.hj01需要打开多少个监控器;

import java.util.*;

/**
 * 1.记录一开始1的数量size
 * 2.将1的上下左右的0都变成1,count++;
 * 3.count加上1的数量size
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
            int[] mnInts = getInts(input.nextLine());
            int m = mnInts[0];
            int n = mnInts[1];
            int[][] grid = buildGrid(m,n,input);
            LinkedList<int[]> oneList = findOneList(m,n,grid);
            int count = oneList.size();
            while (!oneList.isEmpty()) {
                int[] cur = oneList.pop();
                for (int[] director : directors) {
                    int x = director[0] + cur[0];
                    int y = director[1] + cur[1];
                    if (x < 0 || x >= m || y < 0 || y >= n) {
                        continue;
                    }
                    if (grid[x][y] == 0) {
                        grid[x][y] = 1;
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
        input.close();
    }

    private static LinkedList<int[]> findOneList(int m, int n, int[][] grid) {
        LinkedList<int[]> oneList = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    oneList.add(new int[]{i,j});
                }
            }
        }
        return oneList;
    }

    private static int[][] buildGrid(int m, int n, Scanner input) {
        int[][] grid = new int[m][n];
        int index = 0;
        while (index < m) {
            grid[index++] = Arrays.stream(input.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return grid;
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
