package HJ04;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String line = input.nextLine();
            if (Objects.nonNull(line) && line.length() > 0) {
                int left = 0;
                int right = line.length();
                while (left < right && left + 8 <= right) {
                    int end = left + 8;
                    System.out.println(line.substring(left,end));
                    left = end;
                }
                if (left < right && left + 8 > right) {
                    int count = left + 8 - right;
                    String substring = line.substring(left);
                    for (int i = 0; i < count; i++) {
                        substring += "0";
                    }
                    System.out.println(substring);
                }
            }
        }
    }
}
