package hjtest.hj05;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int count = getCount(input.nextLine());
            int[] array = getArray(count, input.nextLine());
            if (array.length == 1) {
                System.out.println(array[0]);
            }
            int min = getMin(array);
            int max = getMax(array);
            int sum = Arrays.stream(array).sum();
            for (int target = min; target <= max; target++) {
                if (canSplit(target, sum, array)) {
                    System.out.println(target);
                    break;
                }
            }
        }
        input.close();
    }

    private static boolean canSplit(int target, int sum, int[] array) {
        if (sum %  target != 0) {
            return false;
        }
        int len = sum / target;
        int[] bucket = new int[len];
        Arrays.fill(bucket, target);
        Arrays.sort(array);
        return backtracking(array, array.length - 1, bucket);
    }

    private static boolean backtracking(int[] array, int cur, int[] bucket) {
        if (cur < 0) {
            return true;
        }
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] == 0) {
                break;
            }
            if (bucket[i] == array[cur] || bucket[i] - array[cur] >= array[0]) {
                bucket[i] -= array[cur];
                if (backtracking(array, cur -1, bucket)) {
                    return true;
                }
                bucket[i] += array[cur];
            }
        }
        return false;
    }

    private static int getMax(int[] array) {
        int sum = Arrays.stream(array).sum();
        return sum / 2 + 1;
    }

    private static int getMin(int[] array) {
        return Arrays.stream(array).max().getAsInt();
    }

    private static int[] getArray(int count, String nextLine) {
        int[] array = new int[count];
        String[] splits = nextLine.split(" ");
        for (int i = 0; i < splits.length; i++) {
            array[i] = Integer.parseInt(splits[i]);
        }
        return array;
    }

    private static int getCount(String nextLine) {
        return Integer.parseInt(nextLine);
    }
}
