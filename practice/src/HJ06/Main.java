package HJ06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextInt()) {
            int inputNumber = input.nextInt();
            List<Integer> result = new ArrayList<>();
            int sqrt = (int)Math.sqrt(inputNumber);
            boolean beDivided = false;
            while (!beDivided) {
                for (int i = 2; i <= sqrt; i++) {
                    if (inputNumber % i == 0) {
                        inputNumber /= i;
                        result.add(i);
                        beDivided = true;
                        break;
                    }
                }
                beDivided = !beDivided;
            }
            if (inputNumber != 1) {
                result.add(inputNumber);
            }
            String res = getResult(result);
            System.out.println(res);
        }
        input.close();
    }

    private static String getResult(List<Integer> result) {
        return result.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }
}
