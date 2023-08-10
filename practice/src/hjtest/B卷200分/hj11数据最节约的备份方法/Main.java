package hjtest.B卷200分.hj11数据最节约的备份方法;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] ints = getInts(input.nextLine());
            System.out.println(Arrays.toString(ints));
            System.out.println(Arrays.stream(ints).sum());
            int left = 0;
            int right = ints.length - 1;
            int count = 0;
            while (left <= right) {
                int cur = ints[right];
                while (ints[left] + cur <= 500) {
                    cur+=ints[left];
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
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
    }
}
