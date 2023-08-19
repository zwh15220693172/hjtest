package hjtest.B复200分.hj06叠积木;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] ints = getInts(input.nextLine());
            if (ints.length == 1) {
                System.out.println(1);
            } else if (ints.length == 2) {
                if (ints[0] == ints[1]) {
                    System.out.println(2);
                } else {
                    System.out.println(1);
                }
            } else {
                int sum = Arrays.stream(ints).sum();
                int min = getMid(ints);
                int max = sum / 2;
                int result = -1;
                for (int i = min; i <= max; i++) {
                    if (canPut(i,ints)) {
                        result = i;
                        break;
                    }
                }
                if (result == -1) {
                    System.out.println(-1);
                } else {
                    System.out.println(sum / result);
                }
            }
        }
        input.close();
    }

    private static boolean canPut(int target, int[] ints) {
        int left = 0;
        int right = ints.length - 1;
        while (left <= right) {
            if (ints[right] == target) {
                right--;
            } else if (left != right && ints[left] + ints[right] == target) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }

    private static int getMid(int[] ints) {
        return Arrays.stream(ints).max().getAsInt();
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
    }
}
