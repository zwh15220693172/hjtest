package hjtest.B卷100分.hj24符合要求的元组的个数;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 注意，相加的sum最好用long类型，不然很容易中招
 * 100%通过
 * 全排列，回溯，使用一个used数组用于去重
 */
public class Main {
    private static int result;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            result = 0;
            long[] ints = getInts(input.nextLine());
            int k = Integer.parseInt(input.nextLine());
            int target = Integer.parseInt(input.nextLine());
            int len = ints.length;
            boolean[] used = new boolean[len];
            getResult(0,k,0,target,0,ints,used);
            System.out.println(result);
        }
        input.close();
    }

    private static void getResult(int cur, int k, long sum, int target,
                                  int start, long[] ints, boolean[] used) {
        if (cur == k) {
            if (sum == target) {
                result++;
            }
            return;
        }
        for (int i = start; i < ints.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && ints[i] == ints[i-1] && !used[i-1]) {
                continue;
            }
            used[i] = true;
            getResult(cur+1,k,sum+ints[i],target,i+1,ints,used);
            used[i] = false;
        }
    }

    private static long[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToLong(Long::parseLong)
                .sorted()
                .toArray();
    }
}
