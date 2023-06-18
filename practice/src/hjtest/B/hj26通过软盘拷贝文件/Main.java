package hjtest.B.hj26通过软盘拷贝文件;

import java.util.Scanner;

public class Main {
    private static final int alone_size = 512;
    private static final int totalSize = 1474560 / alone_size;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int count = Integer.parseInt(input.nextLine());
            int[] values = getValues(count,input);
            int[] sizes = getSize(values);
            int[] dp = new int[totalSize+1];
            for (int i = 0; i < sizes.length; i++) {
                for (int j = totalSize; j >= sizes[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j-sizes[i]]+values[i]);
                }
            }
            System.out.println(dp[totalSize]);
        }
        input.close();
    }

    private static int[] getSize(int[] values) {
        int[] sizes = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            if (values[i] % alone_size == 0) {
                sizes[i] = values[i] / alone_size;
            } else {
                sizes[i] = values[i] / alone_size + 1;
            }
        }
        return sizes;
    }

    private static int[] getValues(int count, Scanner input) {
        int[] values = new int[count];
        int index = 0;
        while (index < count) {
            values[index++] = Integer.parseInt(input.nextLine());
        }
        return values;
    }
}
