package hjtest.B.hj52数字序列比大小;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int len = Integer.parseInt(input.nextLine());
            int[] ints01 = getInts(input.nextLine());
            int[] ints02 = getInts(input.nextLine());
            int slow01 = 0;
            int fast01 = len - 1;
            int slow02 = 0;
            int fast02 = len - 1;
            int win = 0;
            while (slow01 <= fast01) {
                if (ints01[fast01] > ints02[fast02]) {
                    fast01--;
                    fast02--;
                    win++;
                } else if (ints01[fast01] < ints02[fast02]) {
                    slow01++;
                    fast02--;
                    win--;
                } else {
                    if (ints01[slow01] > ints02[slow02]) {
                        slow01++;
                        slow02++;
                        win++;
                    } else {
                        if (ints01[slow01] < ints02[fast02]) {
                            win--;
                        }
                        slow01++;
                        fast02--;
                    }
                }
            }
            System.out.println(win);
        }
        input.close();
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
    }
}
