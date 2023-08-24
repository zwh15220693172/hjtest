package hjtest.B复200分.hj25完全二叉树非叶子后续遍历;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] ints = getInts(input.nextLine());
            List<Integer> result = new ArrayList<>();
            postOrder(0,ints,result);
            String collect = result.stream().map(String::valueOf).collect(Collectors.joining(" "));
            System.out.println(collect);
        }
        input.close();
    }

    private static void postOrder(int cur, int[] ints, List<Integer> result) {
        int left = cur * 2 + 1;
        int right = cur * 2 + 2;
        if (left < ints.length) {
            postOrder(left,ints,result);
        }
        if (right < ints.length) {
            postOrder(right,ints,result);
        }
        if (left < ints.length) {
            result.add(ints[cur]);
        }
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
