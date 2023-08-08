package hjtest.B卷100分.hj20字符串摘要;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 100%通过
 * 注意
 * 1.可以使用一个int[] charcount = new int[128]用来存储小写字母的个数
 * 2.一开始的初始化，要把charCount对应的值给减去
 * 3.注意收尾的工作,再最后添加一个“ “就是用来收尾的，之前的手法不要再用了
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            char[] sources = getSource(input.nextLine());
            int[] charCount = getCharCount(sources);
            char pre = sources[0];
            int count = 1;
            charCount[pre]--;
            List<CharCount> charCountList = new ArrayList<>();
            for (int i = 1; i < sources.length; i++) {
                char cur = sources[i];
                charCount[cur]--;
                if (cur == pre) {
                    count++;
                } else {
                    CharCount curCharCount = new CharCount(pre, count > 1 ? count : charCount[pre]);
                    charCountList.add(curCharCount);
                    pre = cur;
                    count = 1;
                }
            }
            String collect = charCountList.stream().sorted(new Comparator<CharCount>() {
                @Override
                public int compare(CharCount a, CharCount b) {
                    if (b.curCount == a.curCount) {
                        return a.curChar - b.curChar;
                    }
                    return b.curCount - a.curCount;
                }
            }).map(CharCount::toString).collect(Collectors.joining());
            System.out.println(collect);
        }
        input.close();
    }

    private static int[] getCharCount(char[] sources) {
        int[] charCount = new int[128];
        for (int i = 0; i < sources.length - 1; i++) {
            charCount[sources[i]]++;
        }
        return charCount;
    }

    private static char[] getSource(String nextLine) {
        char[] chars = nextLine.toLowerCase().toCharArray();
        List<Character> returnList = new ArrayList<>();
        for (char cur : chars) {
            if (Character.isLetter(cur)) {
                returnList.add(cur);
            }
        }
        char[] returnChars = new char[returnList.size()+1];
        for (int i = 0; i < returnChars.length - 1; i++) {
            returnChars[i] = returnList.get(i);
        }
        return returnChars;
    }

    private static class CharCount {
        private final char curChar;
        private final int curCount;

        public CharCount(char curChar, int curCount) {
            this.curChar = curChar;
            this.curCount = curCount;
        }

        @Override
        public String toString() {
            return curChar + "" + curCount;
        }
    }
}
