package HJ14;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int count = getCount(input.nextLine());
            List<String> listInput = listInput(count, input);
            listInput.stream().sorted(Comparator.naturalOrder())
                    .forEach(System.out::println);
        }
        input.close();
    }

    private static List<String> listInput(int count, Scanner input) {
        List<String> array = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            array.add(input.nextLine());
        }
        return array;
    }

    private static int getCount(String nextLine) {
        return Integer.parseInt(nextLine);
    }
}
