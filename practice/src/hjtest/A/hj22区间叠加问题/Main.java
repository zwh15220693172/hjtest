package hjtest.A.hj22区间叠加问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int len = Integer.parseInt(input.nextLine());
            int[][] source = getInts(len,input);
            sort(source);
            int[][] ints = removeSame(source);
            int target = getTarget(ints);
            int end = ints[0][1];
            int count = 1;
            int result = getResult(0,count,end,target,ints);
            System.out.println(result);
        }
        input.close();
    }

    private static int getResult(int index, int count, int end, int target, int[][] ints) {
        if (end >= target) {
            return count;
        }
        int next = -1;
        int max = end;
        for (int i = index + 1; i < ints.length; i++) {
            int[] cur = ints[i];
            if (cur[0] <= end && cur[1] > max) {
                next = i;
                max = cur[1];
            }
        }
        if (next == -1) {
            return count;
        }
        return getResult(next,count+1,max,target,ints);
    }

    private static int getTarget(int[][] ints) {
        int max = Integer.MIN_VALUE;
        for (int[] anInt : ints) {
            max = Math.max(max,anInt[1]);
        }
        return max;
    }

    private static int[][] removeSame(int[][] source) {
        ArrayList<int[]> list = new ArrayList<>();
        int[] pre = source[0];
        list.add(pre);
        for (int i = 1; i < source.length; i++) {
            int[] cur = source[i];
            if (cur[0] == pre[0]) {
                continue;
            }
            list.add(cur);
            pre = cur;
        }
        return list.toArray(new int[0][]);
    }

    private static void sort(int[][] ints) {
        Arrays.sort(ints, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return b[1] - a[1];
                }
                return a[0] - b[0];
            }
        });
    }

    private static int[][] getInts(int len, Scanner input) {
        int[][] ints = new int[len][];
        int index = 0;
        while (index < len) {
            ints[index++] = Arrays.stream(input.nextLine().split(","))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return ints;
    }
}
