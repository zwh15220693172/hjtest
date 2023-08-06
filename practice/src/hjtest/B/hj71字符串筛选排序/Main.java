package hjtest.B.hj71字符串筛选排序;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            char[] inputChars = input.nextLine().toCharArray();
            int limit = Integer.parseInt(input.nextLine());
            List<CharIndex> listCharIndex = listCharIndex(inputChars, limit);
            listCharIndex.sort(new Comparator<CharIndex>() {
                @Override
                public int compare(CharIndex a, CharIndex b) {
                    if (a.val == b.val) {
                        return a.index - b.index;
                    }
                    return a.val - b.val;
                }
            });
            CharIndex target;
            if (limit > listCharIndex.size()) {
                target = listCharIndex.get(listCharIndex.size()-1);
            } else {
                target = listCharIndex.get(limit-1);
            }
            int index = getTargetIndex(target,listCharIndex);
            System.out.println(index);
        }
        input.close();
    }

    private static int getTargetIndex(CharIndex target, List<CharIndex> listCharIndex) {
        for (CharIndex charIndex : listCharIndex) {
            if (target.val == charIndex.val) {
                return charIndex.index;
            }
        }
        return target.index;
    }

    private static List<CharIndex> listCharIndex(char[] inputChars, int limit) {
        List<CharIndex> listCharIndex = new ArrayList<>();
        for (int i = 0; i < inputChars.length; i++) {
            char curChar = inputChars[i];
            int val = -1;
            if (curChar >= 'A' && curChar <= 'Z') {
                val = curChar - 'A' + 65;
            }
            if (curChar >= 'a' && curChar <= 'z') {
                val = curChar - 'a' + 97;
            }
            CharIndex charIndex = new CharIndex(val, i);
            listCharIndex.add(charIndex);
        }
        return listCharIndex;
    }

    private static class CharIndex {
        private final int val;
        private final int index;

        public CharIndex(int val, int index) {
            this.val = val;
            this.index = index;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof CharIndex)) {
                return false;
            }
            CharIndex other = (CharIndex) obj;
            return this.val == other.val;
        }
    }
}
