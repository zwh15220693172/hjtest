package hjtest.B复.hj05灯路照明;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] params = getInts(input.nextLine());
            int[] ints = getInts(input.nextLine());
            int max = Integer.MIN_VALUE;
            Arrays.sort(ints);
            for (int i = 1; i < ints.length; i++) {
                int cur = ints[i] - ints[i-1];
                max = Math.max(cur,max);
            }
            double result = (double)max / 2;
            String resultStr = String.format("%.2f",result);
            System.out.println(resultStr);
        }
        input.close();
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
