package hjtest.B.hj64最小传输时延1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] nmInts = getInts(input.nextLine());
            int n = nmInts[0];
            int m = nmInts[1];
            int[][] grid = buildGrid(n);
            List<String> xyWeightList = listXyWeight(m,input);
            initGrid(xyWeightList,grid);
            int[] startEndInts = getInts(input.nextLine());
            int start = startEndInts[0] - 1;
            int end = startEndInts[1] - 1;
            int[] dp = grid[start];
            boolean[] used = new boolean[n];
            used[start] = true;
            for (int i = 0; i < n; i++) {
                int nextIndex = -1;
                int weight = Integer.MAX_VALUE;
                for (int j = 0; j < dp.length; j++) {
                    if (!used[j] && dp[j] < weight) {
                        weight = dp[j];
                        nextIndex = i;
                    }
                }
                if (nextIndex == -1) {
                    break;
                }
                used[nextIndex] = true;
                int[] next = grid[nextIndex];
                for (int k = 0; k < next.length; k++) {
                    if (next[k] == Integer.MAX_VALUE) {
                        continue;
                    }
                    dp[k] = Math.min(dp[k],next[k]+weight);
                }
            }
            if (dp[end] == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(dp[end]);
            }
        }
        input.close();
    }

    private static void initGrid(List<String> xyWeightList, int[][] grid) {
        for (String xyWeight : xyWeightList) {
            String[] splits = xyWeight.split(" ");
            int x = Integer.parseInt(splits[0]) - 1;
            int y = Integer.parseInt(splits[1]) - 1;
            int weight = Integer.parseInt(splits[2]);
            grid[x][y] = weight;
        }
    }

    private static List<String> listXyWeight(int m, Scanner input) {
        List<String> list = new ArrayList<>();
        while (m > 0) {
            list.add(input.nextLine());
            m--;
        }
        return list;
    }

    private static int[][] buildGrid(int n) {
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    grid[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        return grid;
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
