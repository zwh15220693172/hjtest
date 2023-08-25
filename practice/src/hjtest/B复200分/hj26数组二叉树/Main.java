package hjtest.B复200分.hj26数组二叉树;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Integer> result = new ArrayList<>();
    private static int min;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            min = Integer.MAX_VALUE;
            int[] ints = getInts(input.nextLine());
            List<Integer> path = new ArrayList<>();
            getResult(0,ints,path);
            System.out.println(result);
        }
        input.close();
    }

    private static void getResult(int cur, int[] ints, List<Integer> path) {
        if (cur >= ints.length) {
            return;
        }
        if (ints[cur] == -1) {
            return;
        }
        List<Integer> list = new ArrayList<>(path);
        list.add(ints[cur]);
        int left = 2 * cur + 1;
        int right = 2 * cur + 2;
        if (left < ints.length && right < ints.length) {
            if (ints[left] == -1 && ints[right] == -1) {
                if (ints[cur] < min) {
                    min = ints[cur];
                    result.clear();
                    result.addAll(list);
                }
            }
        } else if (left >= ints.length && right >= ints.length)  {
            if (ints[cur] < min) {
                min = ints[cur];
                result.clear();
                result.addAll(list);
            }
        }
        if (left < ints.length) {
            getResult(left,ints,list);
        }
        if (right < ints.length) {
            getResult(right,ints,list);
        }
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
