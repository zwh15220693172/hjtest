package hjtest.B.hj54最小循环子数组;

public class LeeCode459 {

    public boolean repeatedSubstringPattern(String s) {
        char[] chars = s.toCharArray();
        int[] next = getNext(chars);
        int len = next.length;
        if (next[len-1] == 0) {
            return false;
        }
        int last = next[len-1];
        int cut = len - last;
        return len % cut == 0;
    }

    private int[] getNext(char[] chars) {
        int[] next = new int[chars.length];
        for (int i = 1, j = 0; i < next.length; i++) {
            while (j > 0 && chars[i] != chars[j]) {
                j = next[j-1];
            }
            if (chars[i] == chars[j]) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
