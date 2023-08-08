package hjtest.B卷100分.hj22阿里巴巴的黄金宝箱3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 100通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] ints = getInts(input.nextLine());
            int target = Integer.parseInt(input.nextLine());
            int result = - 1;
            boolean getIt = false;
            for (int i = 0; i < ints.length; i++) {
                int cur = ints[i];
                int start = i + 1;
                int end = i + target;
                end = Math.min(ints.length - 1, end);
                for (int j = start; j <= end; j++) {
                    int next = ints[j];
                    if (cur == next) {
                        result = i;
                        getIt = true;
                        break;
                    }
                }
                if (getIt) {
                     break;
                }
            }
            System.out.println(result);
        }
        input.close();
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(",")).mapToInt(Integer::parseInt).toArray();
    }
}
