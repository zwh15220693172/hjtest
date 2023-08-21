package hjtest.B复100分.hj35执行时长;

import java.util.Scanner;

/**
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cut = input.nextInt();
        int len = input.nextInt();
        int[] ints = getInts(len,input);
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

    private static int[] getInts(int len, Scanner input) {
        int[] ints = new int[len];
        int index = 0;
        while (index < len) {
            ints[index++] = input.nextInt();
        }
        return ints;
    }
}
