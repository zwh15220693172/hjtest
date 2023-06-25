package hjtest.B.hj30阿里巴巴找黄金宝箱5;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] ints = getInts(input.nextLine());
            int len = Integer.parseInt(input.nextLine());
            int sum = 0;
            for (int i = 0; i < len; i++) {
                sum += ints[i];
            }
            int max = sum;
            for (int i = len; i < ints.length; i++) {
                sum += ints[i];
                sum -= ints[i-len];
                max = Math.max(sum,max);
            }
            System.out.println(max);
        }
        input.close();
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(","))
                .mapToInt(Integer::parseInt).toArray();
    }
}
