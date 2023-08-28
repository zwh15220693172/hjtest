package hjtest.B复200分.hj41最长连续方波信息;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            char[] chars = input.nextLine().toCharArray();
            String result = getResult(chars);
            System.out.println(result);
        }
        input.close();
    }

    private static String getResult(char[] chars) {
        Pattern compile = Pattern.compile("^(01)+0$");
        StringBuilder res = new StringBuilder();
        String result = "-1";
        int maxLen = 0;
        for (int i = 0; i < chars.length; i++) {
            char cur = chars[i];
            if (cur == '0' && i > 0 && chars[i-1] == '0') {
                Matcher matcher = compile.matcher(res.toString());
                if (matcher.matches() && res.length() > maxLen) {
                    result = res.toString();
                    maxLen = res.length();
                }
                res = new StringBuilder();
            }
            res.append(cur);
        }
        if (res.length() > 0) {
            String cur = res.toString();
            if (compile.matcher(cur).matches() && cur.length() > maxLen) {
                result = cur;
                maxLen = cur.length();
            }
        }
        return result;
    }
}
