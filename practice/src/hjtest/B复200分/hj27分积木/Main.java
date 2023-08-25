package hjtest.B复200分.hj27分积木;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextInt()) {
            int len = input.nextInt();
            int[] apples = getApples(len, input);
            int min = Integer.MAX_VALUE;
            int sum = 0;
            int koko = 0;
            for (int apple : apples) {
                koko ^= apple;
                sum += apple;
                min = Math.min(apple,min);
            }
            if (koko != 0) {
                System.out.println("NO");
            } else {
                System.out.println(sum - min);
            }
        }
        input.close();
    }

    private static int[] getApples(int len, Scanner input) {
        int[] apple = new int[len];
        int index = 0;
        while (index < len) {
            apple[index++] = input.nextInt();
        }
        return apple;
    }
}
