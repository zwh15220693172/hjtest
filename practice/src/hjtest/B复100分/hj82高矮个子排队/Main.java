package hjtest.B复100分.hj82高矮个子排队;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] ints = getInts(input.nextLine());
            for (int i = 0; i < ints.length - 1; i++) {
                if (i % 2 == 0) {
                    if (ints[i+1] > ints[i]) {
                        int temp = ints[i];
                        ints[i] = ints[i+1];
                        ints[i+1] = temp;
                    }
                } else {
                    if (ints[i+1] < ints[i]) {
                        int temp = ints[i];
                        ints[i] = ints[i+1];
                        ints[i+1] = temp;
                    }
                }
            }
            String collect = Arrays.stream(ints).mapToObj(String::valueOf)
                    .collect(Collectors.joining(" "));
            System.out.println(collect);
        }
        input.close();
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
