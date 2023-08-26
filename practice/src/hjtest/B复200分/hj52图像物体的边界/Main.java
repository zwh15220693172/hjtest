package hjtest.B复200分.hj52图像物体的边界;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] params = getParams(input.nextLine());
            int m = params[0];
            int n = params[1];
            int[][] grid = buildGrid(m,n,input);
            LinkedList<int[]> fiveList = searchFive(m,n,grid);
            int len = fiveList.size();
            if (len == 0 || len == m * n) {
                System.out.println(0);
            } else {
                UnionSet unionSet = new UnionSet(len);
                for (int i = 0; i < fiveList.size(); i++) {
                    int[] cur = fiveList.get(i);
                    int curX = cur[0];
                    int curY = cur[1];
                    for (int j = i + 1; j < fiveList.size(); j++) {
                        int[] next = fiveList.get(j);
                        int nextX = next[0];
                        int nextY = next[1];
                        if (Math.abs(nextX-curX) <= 3 && Math.abs(nextY-curY) <= 3) {
                            unionSet.join(i,j);
                        }
                    }
                }
                System.out.println(unionSet.count);
            }
        }
    }

    private static LinkedList<int[]> searchFive(int m, int n, int[][] grid) {
        LinkedList<int[]> list = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 5) {
                    list.addLast(new int[]{i,j});
                }
            }
        }
        return list;
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

    private static int[] getParams(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static class UnionSet {
        private int[] pre;
        private int count;

        public UnionSet(int len) {
            count = len;
            pre = new int[len];
            for (int i = 0; i < len; i++) {
                pre[i] = i;
            }
        }

        public int find(int x) {
            while (x != pre[x]) {
                x = pre[x];
            }
            return x;
        }

        public void join(int i, int j) {
            int find_i = find(i);
            int find_j = find(j);
            if (find_i != find_j) {
                pre[find_j] = find_i;
                count--;
            }
        }

        public int count() {
            return this.count;
        }
    }
}
