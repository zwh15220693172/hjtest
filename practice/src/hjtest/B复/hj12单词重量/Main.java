package hjtest.B复.hj12单词重量;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String[] words = input.nextLine().split(" ");
            int sum = Arrays.stream(words).mapToInt(String::length).sum();
            double result = (double)sum / words.length;
            String format = String.format("%.2f", result);
            System.out.println(format);
        }
        input.close();
    }
}
