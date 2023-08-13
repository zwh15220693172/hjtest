package hjtest.B卷200分.hj11数据最节约的备份方法;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 100%通过
 * 二分法+划分为K个相同的子集
 * 注意区间问题，这个是左闭右闭区间，因此，left <= right
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] ints = getInts(input.nextLine());
            int min = 1;
            int max = ints.length;
            int result = -1;
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
        input.close();
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
            int cur = ints[index];
            if (bucket[i] + cur <= 500) {
                bucket[i] += cur;
                if (backtracking(index-1,ints,bucket)) {
                    return true;
                }
                bucket[i] -= cur;
            }
        }
        return false;
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(","))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
    }
}
