package hjtest.leecode.kmp算法;

public class LeeCode459 {
    public boolean repeatedSubstringPattern(String s) {
        char[] chars = s.toCharArray();
        int[] next = getNext(chars);
        int len = s.length();
        if (next[len-1] == 0) {
            return false;
        }
        int array_len = next.length - next[len-1];
        return len % array_len == 0;
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
