package hjtest.B卷200分.hj10通过软盘拷贝文件;

import java.util.Scanner;

public class Main {

    private static final int PART = 512;

    private static final int TOTAL = 1474560;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] values = values(input);
        int[] sizes = sizes(values);
        int total = TOTAL / PART;
        int[] dp = new int[total+1];
        for (int i = 0; i < sizes.length; i++) {
            for (int j = total; j >= sizes[i]; j--) {
                dp[j] = Math.max(dp[j],dp[j-sizes[i]]+values[i]);
            }
        }
        System.out.println(dp[total]);
    }

    private static int[] sizes(int[] values) {
        int[] sizes = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            int cur;
            if (values[i] % PART != 0) {
                cur = values[i] / PART + 1;
            } else {
                cur = values[i] / PART;
            }
            sizes[i] = cur;
        }
        return sizes;
    }

    private static int[] values(Scanner input) {
        int len = input.nextInt();
        int[] values = new int[len];
        for (int i = 0; i < len; i++) {
            values[i] = input.nextInt();
        }
        return values;
    }
}
