package hjtest.leecode.直接干的;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeeCode500 {
    private static final List<Character> line1 = Arrays.asList('q','w','e','r','t','y','u','i','o','p');

    private static final List<Character> line2 = Arrays.asList('a','s','d','f','g','h','j','k','l');

    private static final List<Character> line3 = Arrays.asList('z','x','c','v','b','n','m');

    public String[] findWords(String[] words) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }
            if (word.length() == 1) {
                result.add(word);
                continue;
            }
            char[] chars = word.toCharArray();
            List<Character> line = getLine(Character.toLowerCase(chars[0]));
            boolean getIt = true;
            for (int i = 1; i < chars.length; i++) {
                char cur = Character.toLowerCase(chars[i]);
                if (!line.contains(cur)) {
                    getIt = false;
                    break;
                }
            }
            if (getIt) {
                result.add(word);
            }
        }
        return result.toArray(new String[0]);
    }

    private List<Character> getLine(char start) {
        if (line1.contains(start)) {
            return line1;
        }
        if (line2.contains(start)) {
            return line2;
        }
        return line3;
    }
}
