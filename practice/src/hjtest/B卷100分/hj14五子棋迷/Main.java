package hjtest.B卷100分.hj14五子棋迷;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 注意
 * 1.zeroindex的位置本身可以算作1
 * 2.最大连续长度边长，因此我们要先算一开始的最大连续长度，如果把0换成target，最大连续长度不变，那么没有意义
 * 3.大于最大连续长度，可以不计较位置，相等才计较位置返回中间的那个，注意关联条件
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int target = Integer.parseInt(input.nextLine());
            int[] ints = getInts(input.nextLine());
            int max = getMax(target, ints);
            int result = -1;
            int len = ints.length;
            int mid = len / 2;
            int baseMax = max;
            List<Integer> zeroIndex = zeroIndex(ints);
            for (Integer index : zeroIndex) {
                int count = 1;
                int left = index - 1;
                while (left >= 0 && ints[left] == target) {
                    count++;
                    left--;
                }
                int right = index + 1;
                while (right < len && ints[right] == target) {
                    count++;
                    right++;
                }
                if (count <= 5) {
                    if (count > max) {
                        max = count;
                        result = index;
                    } else if (count == max) {
                        if (Math.abs(index - mid) < Math.abs(result-mid)) {
                            result = index;
                        }
                    }
                }
            }
            if (max == baseMax) {
                System.out.println(-1);
            } else {
                System.out.println(result);
            }
        }
        input.close();
    }

    private static List<Integer> zeroIndex(int[] ints) {
        List<Integer> zeroIndex = new ArrayList<>();
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == 0) {
                zeroIndex.add(i);
            }
        }
        return zeroIndex;
    }

    private static int getMax(int target, int[] ints) {
        int max = 0;
        int count = 0;
        for (int anInt : ints) {
            if (anInt == target) {
                count++;
            } else {
                max = Math.max(count, max);
                count = 0;
            }
        }
        return max;
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
