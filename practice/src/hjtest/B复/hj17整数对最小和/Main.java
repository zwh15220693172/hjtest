package hjtest.B复.hj17整数对最小和;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] ints01 = getInts(input.nextLine());
            int[] ints02 = getInts(input.nextLine());
            int count = Integer.parseInt(input.nextLine());
            int left = 0;
            int right = 0;
            int sum = 0;
            while (left < ints01.length && right < ints02.length && count > 0) {
                sum += ints01[left] + ints02[right];
                if (left + 1 < ints01.length && right + 1 < ints02.length) {
                    if (ints01[left+1] < ints02[right+1]) {
                        left++;
                    } else {
                        right++;
                    }
                }
                count--;
            }
            System.out.println(sum);
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
