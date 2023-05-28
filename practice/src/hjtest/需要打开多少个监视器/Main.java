package hjtest.需要打开多少个监视器;

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
            List<Integer> listMn = listMn(input.nextLine());
            int m = listMn.get(0);
            int n = listMn.get(1);
            int[][] grid = buildGrid(m,n,input);
            LinkedList<int[]> listOne = listOne(m,n,grid);
            int count = listOne.size();
            while (!listOne.isEmpty()) {
                int[] cur = listOne.pop();
                for (int[] director : directors) {
                    int x = cur[0] + director[0];
                    int y = cur[1] + director[1];
                    if (x < 0 || x >= m || y < 0 || y >= n) {
                        continue;
                    }
                    if (grid[x][y] == 0) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
        input.close();
    }

    private static List<Integer> listMn(String nextLine) {
        List<Integer> listMn = new ArrayList<>();
        String[] splits = nextLine.split(" ");
        listMn.add(Integer.parseInt(splits[0]));
        listMn.add(Integer.parseInt(splits[1]));
        return listMn;
    }

    private static LinkedList<int[]> listOne(int m, int n, int[][] grid) {
        LinkedList<int[]> listOne = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    listOne.add(new int[]{i,j});
                }
            }
        }
        return listOne;
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
}
