package hjtest.B卷200分.hj31字符串划分;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            char[] chars = input.nextLine().toCharArray();
            int[] ints = getInts(chars);
            int[] dp = buildDp(ints);
            int[] result = new int[2];
            for (int i = 1; i < dp.length; i++) {
                int part01 = dp[i-1];
                for (int j = dp.length - 1; j > i; j--) {
                    int part02 = dp[j-1] - dp[i];
                    int part03 = dp[dp.length-1] - dp[j];
                    if (part01 == part02 && part02 == part03) {
                        result = new int[] {i,j};
                        break;
                    }
                }
            }
            System.out.println(result[0] + ","+result[1]);
        }
        input.close();
    }

    private static int[] buildDp(int[] ints) {
        int[] dp = new int[ints.length];
        dp[0] = ints[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i-1] + ints[i];
        }
        return dp;
    }

    private static int[] getInts(char[] chars) {
        int[] ints = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            ints[i] = chars[i] - 'a';
        }
        return ints;
    }
}
