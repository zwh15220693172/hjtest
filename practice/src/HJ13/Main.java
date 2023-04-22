package HJ13;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] splits = line.split(" ");
            reserve(splits);
            System.out.println(String.join(" ", splits));
        }
        input.close();
    }

    private static void reserve(String[] splits) {
        int left = 0;
        int right = splits.length - 1;
        while (left < right) {
            String temp = splits[left];
            splits[left] = splits[right];
            splits[right] = temp;
            left++;
            right--;
        }
    }
}
