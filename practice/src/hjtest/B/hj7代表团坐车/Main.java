package hjtest.B.hj7代表团坐车;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] ints = getInts(input.nextLine());
            int target = Integer.parseInt(input.nextLine());
            int[] dp = getDp(ints, target);
            System.out.println(dp[target]);
        }
        input.close();
    }

    private static int[] getDp(int[] ints, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i = 0; i < ints.length; i++) {
            for (int j = target; j >= ints[i]; j--) {
                dp[j] += dp[j-ints[i]];
            }
        }
        return dp;
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(","))
                .mapToInt(Integer::parseInt).toArray();
    }
}
