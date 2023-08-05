package hjtest.B.hj57MELON的难题;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int len = Integer.parseInt(input.nextLine());
            int[] ints = getInts(input.nextLine());
            int sum = Arrays.stream(ints).sum();
            if (sum % 2 != 0) {
                System.out.println(-1);
            } else {
                int target = sum / 2;
                int[] dp = new int[target+1];
                Arrays.fill(dp,Integer.MAX_VALUE);
                dp[0] = 0;
                for (int i = 0; i < ints.length; i++) {
                    for (int j = target; j >= ints[i]; j--) {
                        if (dp[j-ints[i]] != Integer.MAX_VALUE) {
                            dp[j] = Math.min(dp[j],dp[j-ints[i]]+1);
                        }
                    }
                }
                if (dp[target] != Integer.MAX_VALUE) {
                    System.out.println(dp[target]);
                } else {
                    System.out.println(-1);
                }
            }
        }
        input.close();
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
