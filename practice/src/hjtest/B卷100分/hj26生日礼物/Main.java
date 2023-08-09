package hjtest.B卷100分.hj26生日礼物;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 双for循环，有两道超时
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] cakes = getInts(input.nextLine());
            int[] gifts = getInts(input.nextLine());
            int target = Integer.parseInt(input.nextLine());
            int count = 0;
            for (int cake : cakes) {
                if (cake >= target) {
                    break;
                }
                for (int gift : gifts) {
                    if (gift >= target) {
                        break;
                    }
                    if (cake + gift <= target) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
        input.close();
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(","))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
    }
}
