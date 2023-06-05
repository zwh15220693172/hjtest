package hjtest.B.hj11最长公共后缀;

import java.util.Arrays;
import java.util.Comparator;

public class LeeCode14 {
    public String longestCommonPrefix(String[] strs) {
        String min = getMin(strs);
        char[] chars = min.toCharArray();
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            char cur = chars[i];
            boolean sameChar = true;
            for (String str : strs) {
                if (str.charAt(i) != cur) {
                    sameChar = false;
                    break;
                }
            }
            if (!sameChar) {
                break;
            }
            resultBuilder.append(cur);
        }
        return resultBuilder.toString();
    }

    private String getMin(String[] strs) {
        return Arrays.stream(strs).min(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.length() - b.length();
            }
        }).get();
    }
}
