package hjtest.B.hj22阿里巴巴的黄金宝箱4;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] ints = getInts(input.nextLine());
            int[] result = getResult(ints);
            String collect = Arrays.stream(result).mapToObj(String::valueOf)
                    .collect(Collectors.joining(","));
            System.out.println(collect);
        }
        input.close();
    }

    private static int[] getResult(int[] ints) {
        int[] result = new int[ints.length];
        Arrays.fill(result,-1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < ints.length; i++) {
            while (!stack.isEmpty() && ints[i] > ints[stack.peek()]) {
                int index = stack.pop();
                result[index] = ints[i];
            }
            stack.add(i);
        }
        while (!stack.isEmpty()) {
            int index = stack.pop();
            for (int i = 0; i < index; i++) {
                if (ints[i] > ints[index]) {
                    result[index] = ints[i];
                    break;
                }
            }
        }
        return result;
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(","))
                .mapToInt(Integer::parseInt).toArray();
    }
}
