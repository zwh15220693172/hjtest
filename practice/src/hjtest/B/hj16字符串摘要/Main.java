package hjtest.B.hj16字符串摘要;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            char[] chars = input.nextLine().toLowerCase().toCharArray();
            List<CharCount> result = getResult(chars);
            String collect = result.stream().sorted(new Comparator<CharCount>() {
                @Override
                public int compare(CharCount a, CharCount b) {
                    if (a.count == b.count) {
                        return a.cur - b.cur;
                    }
                    return b.count - a.count;
                }
            }).map(CharCount::toString).collect(Collectors.joining());
            System.out.println(collect);
        }
        input.close();
    }

    private static List<CharCount> getResult(char[] chars) {
        List<CharCount> listCharCount = listCharCount(chars);
        List<CharCount> listResult = new ArrayList<>();
        listCharCount.stream().filter((charCount)->Character.isLetter(charCount.cur))
                .forEach((charCount)->{
                    if (charCount.count == 1) {
                        int startIndex = charCount.index;
                        int next = 0;
                        for (int i = startIndex + 1; i < chars.length; i++) {
                            if (chars[i] == charCount.cur) {
                                next++;
                            }
                        }
                        charCount.count = next;
                    }
                    listResult.add(charCount);
                });
        return listResult;
    }

    private static List<CharCount> listCharCount(char[] chars) {
        List<CharCount> listCharCount = new ArrayList<>();
        char pre = ' ';
        int count = 1;
        for (int i = 0; i < chars.length; i++) {
            char cur = chars[i];
            if (cur != pre) {
                CharCount charCount = new CharCount(pre,count,i);
                listCharCount.add(charCount);
                pre = cur;
                count = 1;
            } else {
                count++;
            }
            if (i == chars.length - 1) {
                CharCount charCount = new CharCount(pre,count,i);
                listCharCount.add(charCount);
            }
        }
        return listCharCount;
    }

    private static class CharCount {
        private char cur;
        private int count;
        private int index;

        public CharCount(char cur, int count, int index) {
            this.cur = cur;
            this.count = count;
            this.index = index;
        }

        @Override
        public String toString() {
            return cur + "" + count;
        }
    }
}
