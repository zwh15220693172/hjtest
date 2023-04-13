package HJ07;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextDouble()) {
            double number = input.nextDouble();
            int outputNumber = (int)(number + 0.5);
            System.out.println(outputNumber);
        }
        input.close();
    }
}
