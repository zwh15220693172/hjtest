package hjtest.B复200分.hj13区间交集;

import java.util.*;

/**
 * 有一道题超时
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextInt()) {
            int len = input.nextInt();
            LinkedList<int[]> list = getInts(len, input);
            List<int[]> result = merge(list);
            if (result.isEmpty()) {
                System.out.println("None");
            } else {
                result.forEach(ints -> {
                    System.out.println(ints[0] + " " + ints[1]);
                });
            }
        }
        input.close();
    }

    private static List<int[]> merge(LinkedList<int[]> list) {
        if (list.isEmpty()) {
            return new ArrayList<>();
        }
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return b[1] - a[1];
                }
                return a[0] - b[0];
            }
        });
        List<int[]> result = new ArrayList<>();
        int[] pre = list.poll();
        while (!list.isEmpty()) {
            int[] cur = list.poll();
            if (cur[0] <= pre[1]) {
                pre = new int[]{Math.min(pre[0],cur[0]),Math.max(pre[1],cur[1])};
            } else {
                result.add(pre);
                pre = cur;
            }
        }
        result.add(pre);
        return result;
    }

    private static LinkedList<int[]> getInts(int len, Scanner input) {
        LinkedList<int[]> list = new LinkedList<>();
        int index = 0;
        int[][] ints = new int[len][];
        while (index < len) {
            ints[index++] = new int[]{input.nextInt(), input.nextInt()};
        }
        Arrays.sort(ints, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        for (int i = 0; i < ints.length; i++) {
            for (int j = i + 1; j < ints.length; j++) {
                if (ints[j][0] <= ints[i][1]) {
                    list.add(new int[]{ints[j][0],Math.min(ints[j][1],ints[i][1])});
                }
            }
        }
        return list;
    }
}
