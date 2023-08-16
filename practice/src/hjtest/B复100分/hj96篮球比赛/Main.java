package hjtest.B复100分.hj96篮球比赛;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 100%通过
 */
public class Main {
    private static int result;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            result = Integer.MAX_VALUE;
            int[] ints = getInts(input.nextLine());
            boolean[] used = new boolean[ints.length];
            int total = Arrays.stream(ints).sum();
            getResult(0,5,0,total,ints,used);
            System.out.println(result);
        }
        input.close();
    }

    private static void getResult(int cur, int len, int left, int total, int[] ints, boolean[] used) {
        if (cur == len) {
            int right = total - left;
            int split = Math.abs(left-right);
            result = Math.min(split,result);
            return;
        }
        for (int i = 0; i < ints.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            getResult(cur+1,len,left+ints[i],total,ints,used);
            used[i] = false;
        }
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
