package hjtest.B复.hj14篮球比赛;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] ints = getInts(input.nextLine());
            int sum = Arrays.stream(ints).sum();
            int target = sum / 2;
            int[] dp = new int[target+1];
            for (int num : ints) {
                for (int i = target; i >= num; i--) {
                    dp[i] = Math.max(dp[i],dp[i-num]+num);
                }
            }
            int result = sum - dp[target] - target;
            System.out.println(result);
        }
        input.close();
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
