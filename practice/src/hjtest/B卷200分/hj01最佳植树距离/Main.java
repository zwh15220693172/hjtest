package hjtest.B卷200分.hj01最佳植树距离;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 二分法找一个最大的植树距离
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int len = Integer.parseInt(input.nextLine());
            int[] trees = getTrees(input.nextLine());
            int count = Integer.parseInt(input.nextLine());
            int min = getMin(trees);
            int max = getMax(trees);
            int result = -1;
            while (min <= max) {
                int mid = (min + max) / 2;
                if (canPut(mid,count,trees)) {
                    result = mid;
                    min = mid + 1;
                } else {
                    max = mid - 1;
                }
            }
            System.out.println(result);
        }
        input.close();
    }

    private static boolean canPut(int mid, int count, int[] trees) {
        int pre = trees[0];
        int cur = 1;
        for (int i = 1; i < trees.length; i++) {
            if (trees[i]-pre>=mid) {
                cur++;
                pre = trees[i];
                if (cur == count) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int getMax(int[] trees) {
        return trees[trees.length-1] - trees[0];
    }

    private static int getMin(int[] trees) {
        int mid = Integer.MAX_VALUE;
        for (int i = 0; i < trees.length - 1; i++) {
            int cur = trees[i+1] - trees[i];
            mid = Math.min(cur,mid);
        }
        return mid;
    }

    private static int[] getTrees(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt)
                .sorted().toArray();
    }
}
