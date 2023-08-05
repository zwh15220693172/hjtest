package hjtest.A.hj23连接器问题;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[][] ints = getInts(input.nextLine());
            int[] mergeInts = getMergeInts(input.nextLine());
            boolean[] used = new boolean[mergeInts.length];
            sort(ints);
            int size = ints.length;
            int count = merge(ints,mergeInts,used);
            System.out.println(size - count);
        }
        input.close();
    }

    private static int merge(int[][] ints, int[] mergeInts, boolean[] used) {
        int count = 0;
        int[] pre = ints[0];
        for (int i = 1; i < ints.length; i++) {
            int[] cur = ints[i];
            if (getMerge(pre,cur,mergeInts,used)) {
                count++;
                int left = pre[0];
                int right = Math.max(pre[1],cur[1]);
                pre = new int[]{left, right};
            } else {
                pre = cur;
            }
        }
        return count;
    }

    private static boolean getMerge(int[] pre, int[] cur, int[] mergeInts, boolean[] used) {
        int split;
        if (pre[1] >= cur[0]) {
            split = -1;
        } else {
            split = cur[0] - pre[1];
        }
        for (int i = 0; i < mergeInts.length; i++) {
            if (used[i]) {
                continue;
            }
            if (mergeInts[i] >= split) {
                used[i] = true;
                return true;
            }
        }
        return false;
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

    private static int[] getMergeInts(String nextLine) {
        String replace = nextLine.replaceAll("\\[", "").replaceAll("]", "");
        return Arrays.stream(replace.split(",")).mapToInt(Integer::parseInt).sorted().toArray();
    }

    private static int[][] getInts(String nextLine) {
        String replace = nextLine.replaceAll("\\[", "").replaceAll("]", "");
        String[] splits = replace.split(",");
        int len = splits.length;
        List<int[]> list = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 1;
        while (leftIndex < len && rightIndex < len) {
            int left = Integer.parseInt(splits[leftIndex]);
            int right = Integer.parseInt(splits[rightIndex]);
            leftIndex+=2;
            rightIndex+=2;
            list.add(new int[]{left,right});
        }
        return list.toArray(new int[0][]);
    }
}
