package hjtest.leecode.直接干的;

public class LeeCode541 {
    public static String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int start = 0;
        while (start < len) {
            int left = start;
            int right = Math.min(start+k,len) - 1;
            while (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
            start += 2 * k;
        }
        return new String(chars);
    }
}
