package hjtest.B.hj59计算误码率;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            char[] chars01 = getChars(input.nextLine());
            char[] chars02 = getChars(input.nextLine());
            int len = chars01.length;
            int count = 0;
            for (int i = 0; i < len; i++) {
                if (chars01[i] != chars02[i]) {
                    count++;
                }
            }
            System.out.println(count + "/" + len);
        }
        input.close();
    }

    private static char[] getChars(String nextLine) {
        char[] chars = nextLine.toCharArray();
        List<NumberChar> charList = new ArrayList<>();
        StringBuilder numberBuilder = new StringBuilder();
        for (char aChar : chars) {
            if (Character.isDigit(aChar)) {
                numberBuilder.append(aChar);
            } else {
                int number = Integer.parseInt(numberBuilder.toString());
                String curChar = String.valueOf(aChar);
                numberBuilder = new StringBuilder();
                NumberChar numberChar = new NumberChar(number, curChar);
                charList.add(numberChar);
            }
        }
        StringBuilder resultBuilder = new StringBuilder();
        for (NumberChar numberChar : charList) {
            for (int i = 0; i < numberChar.number; i++) {
                resultBuilder.append(numberChar.curChar);
            }
        }
        return resultBuilder.toString().toCharArray();
    }

    private static class NumberChar {
        private final int number;
        private final String curChar;

        public NumberChar(int number, String curChar) {
            this.number = number;
            this.curChar = curChar;
        }
    }
}
