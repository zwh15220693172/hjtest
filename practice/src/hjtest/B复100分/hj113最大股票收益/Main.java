package hjtest.B复100分.hj113最大股票收益;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] prices = getPrice(input.nextLine());
            int[][] dp = new int[prices.length][2];
            dp[0][0] = -prices[0];
            for (int i = 1; i < dp.length; i++) {
                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
                dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
            }
            System.out.println(dp[dp.length-1][1]);
        }
        input.close();
    }

    private static int[] getPrice(String nextLine) {
        String[] splits = nextLine.split(" ");
        int[] prices = new int[splits.length];
        for (int i = 0; i < splits.length; i++) {
            prices[i] = getPriceDetail(splits[i]);
        }
        return prices;
    }

    private static int getPriceDetail(String split) {
        int digit = Integer.parseInt(split.substring(0,split.length()-1));
        if ('S' == split.charAt(split.length()-1)) {
            return digit * 7;
        }
        return digit;
    }
}
