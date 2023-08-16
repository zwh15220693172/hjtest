package hjtest.B复100分.hj114单词重量;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String[] splits = input.nextLine().split(" ");
            double weight = 0;
            int len = splits.length;
            for (String split : splits) {
                weight += split.length();
            }
            double result = weight / len;
            String format = String.format("%.2f", result);
            System.out.println(format);
        }
        input.close();
    }
}
