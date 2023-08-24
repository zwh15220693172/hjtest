package hjtest.B卷200分.hj05相同数字组成的周长;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 注意边界的时候也要+1
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
            int count = Integer.parseInt(input.nextLine());
            int[][] grid = new int[64][64];
            boolean[][] used = new boolean[64][64];
            LinkedList<Integer> queue = new LinkedList<>();
            while (count > 0) {
                int[] ints = getInts(input.nextLine());
                setGrid(ints, queue, grid);
                count--;
            }
            List<Integer> result = new ArrayList<>();
            while (!queue.isEmpty()) {
                int value = queue.poll();
                int sum = 0;
                for (int i = 0; i < 64; i++) {
                    for (int j = 0; j < 64; j++) {
                        if (grid[i][j] != value || used[i][j]) {
                            continue;
                        }
                        int cur = 0;
                        for (int[] director : directors) {
                            int x = director[0] + i;
                            int y = director[1] + j;
                            if (x >= 0 && x < 64 && y >= 0 && y < 64) {
                                if (grid[x][y] != value) {
                                    cur++;
                                }
                            } else {
                                cur++;
                            }
                        }
                        sum+=cur;
                        used[i][j] = true;
                    }
                }
                result.add(sum);
            }
            String collect = result.stream().map(String::valueOf).collect(Collectors.joining(" "));
            System.out.println(collect);
        }
        input.close();
    }

    private static void setGrid(int[] ints, LinkedList<Integer> queue, int[][] grid) {
        queue.offer(ints[0]);
        int xIndex = 1;
        int yIndex = 2;
        int len = ints.length;
        while (xIndex < len && yIndex < len) {
            int x = ints[xIndex];
            int y = ints[yIndex];
            grid[x][y] = ints[0];
            xIndex+=2;
            yIndex+=2;
        }
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
