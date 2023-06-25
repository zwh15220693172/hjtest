package hjtest.B.hj35数据最节约的备份方法;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final int MAX_SIZE = 500;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] sizes = getInts(input.nextLine());
            Arrays.sort(sizes);
            int count = 0;
            int left = 0;
            int right = sizes.length - 1;
            while (left <= right) {
                if (sizes[left] + sizes[right] <= MAX_SIZE) {
                    left++;
                }
                right--;
                count++;
            }
            System.out.println(count);
        }
        input.close();
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(","))
                .mapToInt(Integer::parseInt).toArray();
    }
}
