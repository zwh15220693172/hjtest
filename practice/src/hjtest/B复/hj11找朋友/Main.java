package hjtest.B复.hj11找朋友;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int len = Integer.parseInt(input.nextLine());
            int[] ints = getInts(input.nextLine());
            int[] result = new int[ints.length];
            Stack<Integer> cursor = new Stack<>();
            for (int i = 0; i < ints.length; i++) {
                while (!cursor.isEmpty() && ints[i] > ints[cursor.peek()]) {
                    int last = cursor.pop();
                    result[last] = i;
                }
                cursor.add(i);
            }
            String collect = Arrays.stream(result).mapToObj(String::valueOf)
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
