package hjtest.B.hj54最小循环子数组;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int len = Integer.parseInt(input.nextLine());
            int[] ints = getInts(input.nextLine());
            int[] next = getNext(ints);
            int last = next[len-1];
            int intsLen = len - last;
            String result = Arrays.stream(ints).limit(intsLen)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" "));
            System.out.println(result);
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
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
