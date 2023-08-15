package hjtest.B复100分.hj42整数对最小和;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextInt()) {
            int len01 = input.nextInt();
            int[] ints01 = getInts(len01,input);
            int len02 = input.nextInt();
            int[] ints02 = getInts(len02,input);
            int k = input.nextInt();
            List<Integer> path = new ArrayList<>();
            for (int int01 : ints01) {
                for (int int02 : ints02) {
                    path.add(int01+int02);
                }
            }
            int result = path.stream().sorted().limit(k)
                    .mapToInt(Integer::intValue).sum();
            System.out.println(result);
        }
        input.close();
    }

    private static int[] getInts(int len, Scanner input) {
        int[] ints = new int[len];
        for (int i = 0; i < len; i++) {
            ints[i] = input.nextInt();
        }
        return ints;
    }
}
