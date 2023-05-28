package hjtest.等和子数组最小和;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int count = Integer.parseInt(input.nextLine());
            int[] ints = getInts(input.nextLine());
            Arrays.sort(ints);
            int min = getMin(ints);
            int max = getMax(ints);
            int result = getResult(min, max, ints);
            System.out.println(result);
        }
        input.close();
    }

    private static int getResult(int min, int max, int[] ints) {
        for (int target = min; target <= max; target++) {
            if (canGetResult(target, ints)) {
                return target;
            }
        }
        return -1;
    }

    private static boolean canGetResult(int target, int[] ints) {
        int k = Arrays.stream(ints).sum() / target;
        int[] bucket = new int[k];
        Arrays.fill(bucket, target);
        return backtracking(ints, ints.length-1, bucket);
    }

    private static boolean backtracking(int[] ints, int index, int[] bucket) {
        if (index < 0) {
            return true;
        }
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] == 0) {
                break;
            }
            if (bucket[i] - ints[index] == 0 || bucket[i] - ints[index] >= ints[0]) {
                bucket[i] -= ints[index];
                if (backtracking(ints, index-1, bucket)) {
                    return true;
                }
                bucket[i] += ints[index];
            }
        }
        return false;
    }

    private static int getMax(int[] ints) {
        int sum = Arrays.stream(ints).sum();
        return sum / 2;
    }

    private static int getMin(int[] ints) {
        return Arrays.stream(ints).max().getAsInt();
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
