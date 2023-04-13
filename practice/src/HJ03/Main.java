package HJ03;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextInt()) {
            int count = input.nextInt();
            HashSet<Integer> set = new LinkedHashSet<>();
            while (count > 0) {
                int num = input.nextInt();
                set.add(num);
                count--;
            }
            set.stream().sorted().forEach(System.out::println);
        }
    }
}
