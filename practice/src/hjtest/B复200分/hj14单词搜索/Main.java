package hjtest.B复200分.hj14单词搜索;

import java.util.Arrays;
import java.util.Scanner;

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
            int[] params = getParams(input.nextLine());
            int m = params[0];
            int n = params[1];
            char[] target = input.nextLine().toCharArray();
            char[][] grid = buildGrid(m,n,input);
            int[] resultInt = new int[2];
            boolean getResult = false;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == target[0]) {
                        if (backtracking(i,j,m,n,1,target,grid)) {
                            getResult = true;
                            resultInt = new int[] {i+1,j+1};
                            break;
                        }
                    }
                }
            }
            if (getResult) {
                System.out.println(resultInt[0] + " " + resultInt[1]);
            } else {
                System.out.println("NO");
            }
        }
        input.close();
    }

    private static boolean backtracking(int i, int j, int m, int n, int cur, char[] target, char[][] grid) {
        if (cur == target.length) {
            return true;
        }
        for (int[] director : directors) {
            int x = i + director[0];
            int y = j + director[1];
            if (x < 0 || x >= m || y < 0 || y >= n) {
                continue;
            }
            if (grid[x][y] != target[cur]) {
                continue;
            }
            if (backtracking(x,y,m,n,cur+1,target,grid)) {
                return true;
            }
        }
        return false;
    }

    private static char[][] buildGrid(int m, int n, Scanner input) {
        char[][] grid = new char[m][n];
        int index = 0;
        while (index < m) {
            grid[index++] = input.nextLine().toCharArray();
        }
        return grid;
    }

    private static int[] getParams(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
