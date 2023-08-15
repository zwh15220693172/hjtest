package hjtest.B复100分.hj25数列描述;

import java.util.Scanner;

/**
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int n = Integer.parseInt(input.nextLine());
            String[] dp = new String[n+1];
            dp[0] = "1";
            for (int i = 1; i <= n; i++) {
                dp[i] = getDp(dp[i-1]);
            }
            System.out.println(dp[n]);
        }
        input.close();
    }

    private static String getDp(String last) {
        char[] chars = last.toCharArray();
        char pre = chars[0];
        int count = 1;
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < chars.length; i++) {
            char cur = chars[i];
            if (cur == pre) {
                count++;
            } else {
                result.append(count).append(pre);
                pre = cur;
                count = 1;
            }
        }
        result.append(count).append(pre);
        return result.toString();
    }
}
