package hjtest;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] ints = getInts(input.nextLine());
        int min = 1;
        int max = ints.length;
        int result = 0;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (canPut(mid,ints)) {
                result = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(result);
    }

    private static boolean canPut(int mid, int[] ints) {
        int[] bucket = new int[mid];
        return backtracking(ints.length-1,ints,bucket);
    }

    private static boolean backtracking(int index, int[] ints, int[] bucket) {
        if (index < 0) {
            return true;
        }
        for (int i = 0; i < bucket.length; i++) {
            if (i > 0 && bucket[i] == bucket[i-1]) {
                continue;
            }
            if (bucket[i] + ints[index] <= 500) {
                bucket[i] += ints[index];
                if (backtracking(index-1,ints,bucket)) {
                    return true;
                }
                bucket[i] -= ints[index];
            }
        }
        return false;
    }

    private static int[] getInts(String nextLine) {
        int[] array = Arrays.stream(nextLine.split(","))
                .mapToInt(Integer::parseInt).toArray();
        Arrays.sort(array);
        return array;
    }
}
