package hjtest.B卷100分.hj22阿里巴巴的黄金宝箱3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 100通过
 * 1.输入的数字为k,那么我们就找i+1到i+k之间的数,定义这个区间为j
 * 2.如果ints[i]==ints[j]那么输出i直接结束循环
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
