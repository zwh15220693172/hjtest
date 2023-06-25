package hjtest.B.hj33经典屏保;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static int x = 1;
    private static int y = 1;

    private static final int width = 50;
    private static final int height = 25;

    private static final int max_x = 800;
    private static final int max_y = 600;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] ints = getInts(input.nextLine());
            int curX = ints[0];
            int curY = ints[1];
            int time = ints[2];
            while (time > 0) {
                curX+=x;
                curY+=y;
                if (curX <= 0 || curX + width >= max_x) {
                    x = -x;
                }
                if (curY <= 0 || curY + height >= max_y) {
                    y = -y;
                }
                time--;
            }
            System.out.println(curX + " " + curY);
        }
        input.close();
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
