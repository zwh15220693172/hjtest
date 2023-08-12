package hjtest.B卷100分.hj20字符串摘要;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 100%通过
 * 注意
 * 1.首先去除字符串中出现的奇怪的字符
 * 2.使用一个chaCount用来记录每一个字母出现的次数
 * 3.字符数组的末尾使用' '方便收尾
 * 4.创建一个charCount的对象，char为对应的char，count为数量
 * 5.初始化.pre= chars[0],并且让对应的char再charCount内--
 * 6.chars从1开始，如果pre == cur，那么count++，记得charCount要减去相应的值
 * 7.如果pre != cur
 * 8.如果count > 1 那么直接生成对象
 * 9.否则从charCount里面取值
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
