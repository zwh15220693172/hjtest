package hjtest.leecode.直接干的;

public class LeeCode738 {

    public static void main(String[] args) {
        LeeCode738 leeCode738 = new LeeCode738();
        System.out.println(leeCode738.monotoneIncreasingDigits(120));
    }

    public int monotoneIncreasingDigits(int n) {
        String target = getTarget(n);
        return Integer.parseInt(target);
    }

    private String getTarget(int n) {
        String num = String.valueOf(n);
        char[] digits = num.toCharArray();
        for (int i = digits.length - 1; i > 0; i--) {
            char cur = digits[i];
            char next = digits[i-1];
            if (cur >= next) {
                continue;
            }
            for (int j = i; j < digits.length; j++) {
                digits[j] = '9';
            }
            digits[i-1] = (char)(next - 1);
        }
        return new String(digits);
    }
}
