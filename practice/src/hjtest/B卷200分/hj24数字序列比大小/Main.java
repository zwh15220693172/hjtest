package hjtest.B卷200分.hj24数字序列比大小;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 田忌赛马
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int len = Integer.parseInt(input.nextLine());
            int[] ints01 = getInts(input.nextLine());
            int[] ints02 = getInts(input.nextLine());
            int left01 = 0;
            int right01 = ints01.length - 1;
            int left02 = 0;
            int right02 = ints02.length - 1;
            int point = 0;
            while (left01 <= right01 && left02 <= right02) {
                if (ints01[right01] > ints02[right02]) {
                    right01--;
                    right02--;
                    point++;
                } else if (ints01[right01] < ints02[right02]) {
                    left01++;
                    right02--;
                    point--;
                } else {
                    if (ints01[left01] > ints02[left02]) {
                        left01++;
                        left02++;
                        point++;
                    } else {
                        if (ints01[left01] < ints02[right02]) {
                            point--;
                        }
                        left01++;
                        right02--;
                    }
                }
            }
            System.out.println(point);
        }
        input.close();
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).sorted().toArray();
    }
}
