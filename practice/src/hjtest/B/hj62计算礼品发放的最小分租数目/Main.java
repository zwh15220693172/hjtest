package hjtest.B.hj62计算礼品发放的最小分租数目;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int target = Integer.parseInt(input.nextLine());
            int[] ints = getInts(input.nextLine());
            int left = 0;
            int right = ints.length - 1;
            int count = 0;
            while (left <= right) {
                if (ints[left] + ints[right] <= target) {
                    left++;
                }
                count++;
                right--;
            }
            System.out.println(count);
        }
        input.close();
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).sorted()
                .toArray();
    }
}
