package hjtest.B复.hj10最大股票收益;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] prices = getPrices(input.nextLine());
            int[][] dp = new int[prices.length][2];
            dp[0][0] = -prices[0];
            for (int i = 1; i < prices.length; i++) {
                dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]-prices[i]);
                dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]+prices[i]);
            }
            System.out.println(dp[prices.length-1][1]);
        }
        input.close();
    }

    private static int[] getPrices(String nextLine) {
        String[] splits = nextLine.split(" ");
        int[] prices = new int[splits.length];
        for (int i = 0; i < splits.length; i++) {
            prices[i] = calPrice(splits[i]);
        }
        return prices;
    }

    private static int calPrice(String split) {
        String type = split.substring(split.length()-1);
        String numberStr = split.substring(0,split.length()-1);
        int price = Integer.parseInt(numberStr);
        if ("S".equals(type)) {
            return price * 7;
        }
        return price;
    }
}
