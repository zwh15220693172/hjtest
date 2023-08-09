package hjtest.B卷100分.hj32最长公共后缀;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 从后面开始往前找前缀
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        String[] strings =
                Arrays.stream(line.substring(1, line.length() - 1).split(","))
                        .map(s -> s.substring(1, s.length() - 1))
                        .toArray(String[]::new);

        System.out.println(getResult(strings));
    }

    private static String getResult(String[] strings) {
        String mid = findMid(strings);
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= mid.length(); i++) {
            char cur = mid.charAt(mid.length()-i);
            boolean match = true;
            for (String string : strings) {
                char next = string.charAt(string.length()-i);
                if (cur != next) {
                    match = false;
                    break;
                }
            }
            if (match) {
                result.insert(0,cur);
            } else {
                break;
            }
        }
        return result.length() == 0 ? "@Zero" : result.toString();
    }

    private static String findMid(String[] strings) {
        return Arrays.stream(strings)
                .min(Comparator.comparing(String::length))
                .get();
    }
}
