package hjtest.B复100分.hj110找朋友;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextInt()) {
            int len = input.nextInt();
            int[] ints = getInts(len,input);
            int[] result = new int[ints.length];
            Stack<Integer> cursor = new Stack<>();
            for (int i = 0; i < ints.length; i++) {
                int cur = ints[i];
                while (!cursor.isEmpty() && cur > ints[cursor.peek()]) {
                    int index = cursor.pop();
                    result[index] = i;
                }
                cursor.push(i);
            }
            String collect = Arrays.stream(result).mapToObj(String::valueOf)
                    .collect(Collectors.joining(" "));
            System.out.println(collect);
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
