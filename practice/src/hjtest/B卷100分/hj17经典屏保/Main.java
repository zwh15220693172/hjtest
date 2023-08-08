package hjtest.B卷100分.hj17经典屏保;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 100%通过
 * 注意，开始的坐标是左上角的坐标
 * 因此，不需要x-L_WIDTH == 0 左边的判断
 *      不需要y-L_HEIGHT == 0 下边的判断
 */
public class Main {
    private static final int TOTAL_WIDTH = 800;
    private static final int TOTAL_HEIGHT = 600;

    private static final int L_WIDTH = 50;
    private static final int L_HEIGHT = 25;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] xyTime = getInts(input.nextLine());
            int x = xyTime[0];
            int y = xyTime[1];
            int moveX = 1;
            int moveY = 1;
            int time = xyTime[2];
            while (time > 0) {
                x+=moveX;
                y+=moveY;
                if (x == 0 || x + L_WIDTH >= TOTAL_WIDTH) {
                    moveX = -moveX;
                }
                if (y == 0 || y + L_HEIGHT >= TOTAL_HEIGHT) {
                    moveY = -moveY;
                }
                time--;
            }
            System.out.println(x + " " + y);
        }
        input.close();
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
