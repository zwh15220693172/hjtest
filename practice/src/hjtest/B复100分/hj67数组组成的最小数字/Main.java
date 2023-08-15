package hjtest.B复100分.hj67数组组成的最小数字;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] source = getSource(input.nextLine());
            String[] ints = getInts(source);
            Arrays.sort(ints, new Comparator<String>() {
                @Override
                public int compare(String a, String b) {
                    return (a+b).compareTo(b+a);
                }
            });
            String result = String.join("", ints);
            System.out.println(result);
        }
        input.close();
    }

    private static String[] getInts(int[] source) {
        int len = Math.min(source.length,3);
        String[] ints = new String[len];
        for (int i = 0; i < len; i++) {
            ints[i] = String.valueOf(source[i]);
        }
        return ints;
    }

    private static int[] getSource(String nextLine) {
        return Arrays.stream(nextLine.split(","))
                .mapToInt(Integer::parseInt)
                .sorted().toArray();
    }
}
