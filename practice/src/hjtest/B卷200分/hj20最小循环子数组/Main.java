package hjtest.B卷200分.hj20最小循环子数组;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 求next数组
 * 然后输出最小循环子数组
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int len = Integer.parseInt(input.nextLine());
            int[] ints = getInts(input.nextLine());
            int[] next = getNext(ints);
            int substring = next[next.length-1];
            int end = len - substring;
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < end; i++) {
                result.add(ints[i]);
            }
            String collect = result.stream().map(String::valueOf)
                    .collect(Collectors.joining(" "));
            System.out.println(collect);
        }
        input.close();
    }

    private static int[] getNext(int[] ints) {
        int[] next = new int[ints.length];
        for (int i = 1, j = 0; i < next.length; i++) {
            while (j > 0 && ints[i] != ints[j]) {
                j = next[j-1];
            }
            if (ints[i] == ints[j]) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
