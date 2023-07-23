package hjtest.B复.hj03分苹果;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int count = Integer.parseInt(input.nextLine());
            int[] weights = getWeight(input.nextLine());
            int sumA = 0;
            int sumB = 0;
            int min = Integer.MAX_VALUE;
            for (int weight : weights) {
                sumA ^= weight;
                sumB += weight;
                min = Math.min(min,weight);
            }
            if (sumA == 0) {
                System.out.println(sumB - min);
            } else {
                System.out.println(-1);
            }
        }
        input.close();
    }

    private static int[] getWeight(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
