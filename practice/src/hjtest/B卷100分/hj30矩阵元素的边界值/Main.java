package hjtest.B卷100分.hj30矩阵元素的边界值;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int[][] matrix =
                Arrays.stream(line.substring(2, line.length() - 2).split("],\\["))
                        .map(s -> Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray())
                        .toArray(int[][]::new);

        System.out.println(getResult(matrix));
    }

    private static int getResult(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int cur = Integer.MIN_VALUE;
            for (int j = 0; j < m; j++) {
                cur = Math.max(matrix[j][i], cur);
            }
            result = Math.min(result, cur);
        }
        return result;
    }
}
