package HJ15;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextInt()) {
            int number = input.nextInt();
            int count = 0;
            while (number > 0) {
                if (number % 2 == 1) {
                    count++;
                }
                number /= 2;
            }
            System.out.println(count);
        }
        input.close();
    }
}
