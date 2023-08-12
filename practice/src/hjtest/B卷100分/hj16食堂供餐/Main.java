package hjtest.B卷100分.hj16食堂供餐;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 100%通过
 * 注意的点：
 * 二分法处理
 * 1.左闭右闭区间，中间为left <= right
 * 2.min = 1
 * 3.max = 总人数 - remain
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int len = Integer.parseInt(input.nextLine());
            int remain = Integer.parseInt(input.nextLine());
            int[] cost = getInts(input.nextLine());
            int max = getMax(cost, remain);
            int left = 1;
            int right = max;
            int result = 0;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (canPut(mid, remain, cost)) {
                    result = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            System.out.println(result);
        }
        input.close();
    }

    private static boolean canPut(int mid, int remain, int[] cost) {
        for (int cur : cost) {
            if (cur > remain) {
                return false;
            }
            remain = remain - cur + mid;
        }
        return true;
    }

    private static int getMax(int[] cost, int remain) {
        int sum = Arrays.stream(cost).sum();
        return sum - remain;
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
