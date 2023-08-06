package hjtest.B.hj70数列描述;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int m = Integer.parseInt(input.nextLine());
            String[] dp = new String[m+1];
            dp[0] = "1";
            for (int i = 1; i <= m; i++) {
                char[] chars = dp[i - 1].toCharArray();
                int count = -1;
                char pre = ' ';
                StringBuilder curBuilder = new StringBuilder();
                for (int j = 0; j < chars.length; j++) {
                    if (j == 0) {
                        pre = chars[j];
                        count = 1;
                    } else {
                        if (chars[j] == pre) {
                            count++;
                        } else {
                            curBuilder.append(count).append(pre);
                            pre = chars[j];
                            count = 1;
                        }
                    }
                    if (j == chars.length - 1) {
                        curBuilder.append(count).append(pre);
                    }
                }
                dp[i] = curBuilder.toString();
            }
            System.out.println(dp[m]);
        }
        input.close();
    }
}
