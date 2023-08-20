package hjtest.B复200分.hj11连续出牌数量;

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
            result = Integer.MIN_VALUE;
            int[] ints = getInts(input.nextLine());
            String[] colors = input.nextLine().split(" ");
            int len = ints.length;
            boolean[] used = new boolean[ints.length];
            for (int i = 0; i < len; i++) {
                used[i] = true;
                backtracking(1,len,i,ints,colors,used);
                used[i] = false;
            }
            System.out.println(result);
        }
        input.close();
    }

    private static void backtracking(int cur, int len, int last, int[] ints, String[] colors, boolean[] used) {
        if (cur > len) {
            return;
        }
        result = Math.max(cur,result);
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            if (ints[i] == ints[last] || colors[i].equals(colors[last])) {
                used[i] = true;
                backtracking(cur+1,len,i,ints,colors,used);
                used[i] = false;
            }
        }
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
