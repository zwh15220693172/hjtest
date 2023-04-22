package HJ11;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String inputStr = input.nextLine();
            char[] chars = inputStr.toCharArray();
            reserve(chars);
            System.out.println(new String(chars));
        }
        input.close();
    }

    private static void reserve(char[] chars) {
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
