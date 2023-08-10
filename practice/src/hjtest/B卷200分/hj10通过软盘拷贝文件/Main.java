package hjtest.B卷200分.hj10通过软盘拷贝文件;

import java.util.Scanner;

/**
 * 这道题就是01背包问题，不过要搞清楚
 * 1.背包的总容量为1474560 / 512
 * 2.每一个文件的价值为N,
 * 但是容量并不是为N，如果N / 512 == 0，那么容量为N / 512 否则为 N / 512 + 1
 * 100%通过有超时的
 */
public class Main {
    private static final int TOTAL_SIZE = 1474560;
    private static final int PART_SIZE = 512;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int len = Integer.parseInt(input.nextLine());
            int[] values = getValues(len,input);
            int[] weights = getWeights(values);
            int total = TOTAL_SIZE / PART_SIZE;
            int[] dp = new int[total+1];
            for (int i = 0; i < len; i++) {
                for (int j = total; j >= weights[i]; j--) {
                    dp[j] = Math.max(dp[j],dp[j-weights[i]]+values[i]);
                }
            }
            System.out.println(dp[total]);
        }
        input.close();
    }

    private static int[] getWeights(int[] values) {
        int[] weights = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            if (values[i] % PART_SIZE == 0) {
                weights[i] = values[i] / PART_SIZE;
            } else {
                weights[i] = values[i] / PART_SIZE + 1;
            }
        }
        return weights;
    }

    private static int[] getValues(int len, Scanner input) {
        int[] values = new int[len];
        int index = 0;
        while (index < len) {
            values[index++] = Integer.parseInt(input.nextLine());
        }
        return values;
    }
}
