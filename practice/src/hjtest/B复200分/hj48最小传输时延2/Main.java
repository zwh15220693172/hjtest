package hjtest.B复200分.hj48最小传输时延2;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 100%通过
 */
public class Main {
    private static final int[][] directors = {
            {1,0}, {-1,0}, {0,1}, {0,-1},
            {1,1}, {1,-1}, {-1,1}, {-1,-1}
    };

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        int[][] grid = new int[m][n];
        init(m,n,grid,input);
        int[][] dist = buildDist(m,n);
        dist[0][0] = grid[0][0];
        LinkedList<int[]> queue = new LinkedList<>();
        queue.addLast(new int[]{0,0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int i = cur[0];
            int j = cur[1];
            for (int[] director : directors) {
                int x = i + director[0];
                int y = j + director[1];
                if (x < 0 || y < 0 || x >= m || y >= n) {
                    continue;
                }
                int next = grid[x][y] + dist[i][j];
                if (grid[x][y] == grid[i][j]) {
                    next-=1;
                }
                if (next < dist[x][y]) {
                    dist[x][y] = next;
                    queue.addLast(new int[]{x,y});
                }
            }
        }
        System.out.println(dist[m-1][n-1]);
    }

    private static int[][] buildDist(int m, int n) {
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        return dist;
    }

    private static void init(int m, int n, int[][] grid, Scanner input) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = input.nextInt();
            }
        }
    }
}
