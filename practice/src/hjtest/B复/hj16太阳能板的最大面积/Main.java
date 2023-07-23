package hjtest.B复.hj16太阳能板的最大面积;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] ints = getInts(input.nextLine());
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < ints.length; i++) {
                int height = ints[i];
                for (int j = i + 1; j < ints.length; j++) {
                    int cur = (ints[j] - height) * height;
                    max = Math.max(cur,max);
                }
            }
            System.out.println(max);
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
