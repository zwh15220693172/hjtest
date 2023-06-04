package hjtest.B.hj3最佳植树距离;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int len = Integer.parseInt(input.nextLine());
            int[] ints = getInts(input.nextLine());
            int m = Integer.parseInt(input.nextLine());
            int result = getResult(ints,m);
            System.out.println(result);
        }
        input.close();
    }

    private static int getResult(int[] ints, int m) {
        Arrays.sort(ints);
        int min = getMin(ints);
        int max = getMax(ints);
        int result = 0;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (canPut(mid,m,ints)) {
                result = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return result;
    }

    private static boolean canPut(int mid, int m, int[] ints) {
        int count = 1;
        int pre = ints[0];
        for (int i = 1; i < ints.length; i++) {
            if (ints[i] - pre >= mid) {
                count++;
                pre = ints[i];
                if (count >= m) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int getMax(int[] ints) {
        return ints[ints.length-1]-ints[0];
    }

    private static int getMin(int[] ints) {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < ints.length; i++) {
            min = Math.min(ints[i]-ints[i-1],min);
        }
        return min;
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
