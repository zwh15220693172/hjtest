package hjtest.B卷200分.hj09阿里巴巴的黄金宝箱4;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * 单调栈
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] ints = getInts(input.nextLine());
            int[] result = new int[ints.length];
            Arrays.fill(result,-1);
            Stack<Integer> cursor = new Stack<>();
            for (int i = 0; i < ints.length; i++) {
                while (!cursor.isEmpty() && ints[i] > ints[cursor.peek()]) {
                    int last = cursor.pop();
                    result[last] = ints[i];
                }
                cursor.push(i);
            }
            while (!cursor.isEmpty()) {
                int index = cursor.pop();
                for (int i = 0; i < index; i++) {
                    if (ints[i]>ints[index]) {
                        result[index] = ints[i];
                        break;
                    }
                }
            }
            String collect = Arrays.stream(result).mapToObj(String::valueOf)
                    .collect(Collectors.joining(","));
            System.out.println(collect);
        }
        input.close();
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(","))
                .mapToInt(Integer::parseInt).toArray();
    }
}
