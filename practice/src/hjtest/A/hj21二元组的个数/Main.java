package hjtest.A.hj21二元组的个数;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int len01 = Integer.parseInt(input.nextLine());
            int[] ints01 = getInts(input.nextLine());
            Arrays.sort(ints01);
            int len02 = Integer.parseInt(input.nextLine());
            int[] ints02 = getInts(input.nextLine());
            Arrays.sort(ints02);
            int count = 0;
            for (int i = 0; i < len01; i++) {
                for (int j = 0; j < len02; j++) {
                    if (ints02[j] > ints01[i]) {
                        continue;
                    }
                    if (ints01[i] == ints02[j]) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
        input.close();
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
