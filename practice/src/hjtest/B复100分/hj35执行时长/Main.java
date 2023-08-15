package hjtest.B复100分.hj35执行时长;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int cut = Integer.parseInt(input.nextLine());
            int len = Integer.parseInt(input.nextLine());
            int[] ints = getInts(input.nextLine());
            int remain = 0;
            int time = 0;
            for (int cur : ints) {
                if (remain + cur <= cut) {
                    remain = 0;
                } else {
                    remain = remain + cur - cut;
                }
                time++;
            }
            while (remain > 0) {
                remain-=cut;
                time++;
            }
            System.out.println(time);
        }
        input.close();
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
