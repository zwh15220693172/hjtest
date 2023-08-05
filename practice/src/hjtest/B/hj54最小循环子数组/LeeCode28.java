package hjtest.B.hj54最小循环子数组;

public class LeeCode28 {
    public int strStr(String haystack, String needle) {
        char[] hChars = haystack.toCharArray();
        char[] nChars = needle.toCharArray();
        int[] next = getNext(nChars);
        for (int i = 0, j = 0; i < hChars.length; i++) {
            while (j > 0 && hChars[i] != nChars[j]) {
                j = next[j-1];
            }
            if (hChars[i] == nChars[j]) {
                j++;
            }
            if (j == nChars.length) {
                return i - j + 1;
            }
        }
        return -1;
    }

    private int[] getNext(char[] nChars) {
        int[] next = new int[nChars.length];
        for (int i = 1, j = 0; i < next.length; i++) {
            while (j > 0 && nChars[i] != nChars[j]) {
                j = next[j-1];
            }
            if (nChars[i] == nChars[j]) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
