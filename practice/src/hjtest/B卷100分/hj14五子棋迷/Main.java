package hjtest.B卷100分.hj14五子棋迷;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 注意
 1.先记录0的位置
 2.题目的要求为，大于最大连续长度，如果有多个这样子的值，我们输出中间的
 3.因此我们需要求现在的最大连续长度
 4.需要求中间的位置是什么
 5.从0开始，左边等于target++
 6.从0开始，右边等于target++
 7.0本身的位置count已经==1了注意
 8.注意这个count必须<=5
 9.如果当前大于最大连续长度，那么记录这个下标
 10.如果等于最大连续长度，那么记录中间的位置
 11.我们还需要与原先的最大长度做比较，如果等于原先的最大长度，那么输出-1
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
