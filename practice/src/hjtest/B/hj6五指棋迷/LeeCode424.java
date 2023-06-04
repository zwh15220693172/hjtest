package hjtest.B.hj6五指棋迷;

public class LeeCode424 {

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println(characterReplacement(s, k));
    }

    public static int characterReplacement(String s, int k) {
        char[] chars = s.toCharArray();
        int[] charCount = new int[26];
        int right = 0;
        int left = 0;
        int maxCount = 0;
        while (right < chars.length) {
            char cur = chars[right];
            int index = cur - 'A';
            charCount[index]++;
            maxCount = Math.max(charCount[index],maxCount);
            while (right - left + 1 > maxCount + k) {
                charCount[chars[left]-'A']--;
                left++;
            }
            right++;
        }
        return right - left;
    }
}
