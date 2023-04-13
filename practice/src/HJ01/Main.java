package HJ01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String line = input.nextLine();
            if (line != null && line.length() > 0) {
                String[] strings = line.split(" ");
                String last = strings[strings.length - 1];
                System.out.println(last.length());
            }
        }
    }
}
