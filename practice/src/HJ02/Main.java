package HJ02;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String line = input.nextLine();
            String inputChar = input.nextLine();
            int count = 0;
            if (fitStatus(line,inputChar)) {
                char equalChar = inputChar.charAt(0);
                char[] chars = line.toCharArray();
                for (char aChar : chars) {
                    if (Character.toLowerCase(aChar) == Character.toLowerCase(equalChar)) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
        input.close();
    }

    private static boolean fitStatus(String line, String inputChar) {
        if (Objects.isNull(line) ||line.length() <= 0) {
            return false;
        }
        if (Objects.isNull(inputChar) || inputChar.length() != 1) {
            return false;
        }
        return true;
    }
}
