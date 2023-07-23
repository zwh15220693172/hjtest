package hjtest.B.hj42战场索敌;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final int[][] directors = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };
    private static int m;
    private static int n;
    private static String[][] grid;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] params = getParams(input.nextLine());
            m = params[0];
            n = params[1];
            int target = params[2];
            grid = buildGrid(input);
            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!grid[i][j].equals("E")) {
                        continue;
                    }
                    int result = getResult(i,j,0);
                    if (result < target) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
        input.close();
    }

    private static int getResult(int i, int j, int num) {
        num++;
        grid[i][j] = ".";
        for (int[] director : directors) {
            int x = i + director[0];
            int y = j + director[1];
            if (x < 0 || x >= m || y < 0 || y >= n) {
                continue;
            }
            if (!grid[x][y].equals("E")) {
                continue;
            }
            num = getResult(x,y,num);
        }
        return num;
    }

    private static String[][] buildGrid(Scanner input) {
        String[][] grid = new String[m][n];
        int index = 0;
        while (index < m) {
            grid[index++] = input.nextLine().split("");
        }
        return grid;
    }

    private static int[] getParams(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
