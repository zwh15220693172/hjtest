package hjtest.B卷200分.hj33编码能力提升计划;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] ints = getInts(input.nextLine());
            int day = Integer.parseInt(input.nextLine());
            if (day >= ints.length) {
                System.out.println(0);
            } else {
                int min = 0;
                int max = getMax(ints);
                int result = 0;
                while (min <= max) {
                    int mid = (min + max) / 2;
                    if (canPut(mid,ints,day)) {
                        result = mid;
                        max = mid - 1;
                    } else {
                        min = mid + 1;
                    }
                }
                System.out.println(result);
            }
        }
    }

    private static boolean canPut(int mid, int[] ints, int day) {
        int cur = 1;
        int sum = 0;
        int max = 0;
        int index = 0;
        boolean remove = false;
        while (index < ints.length) {
            sum += ints[index];
            max = Math.max(max,ints[index]);
            if (sum > mid) {
                if (!remove) {
                    sum -= max;
                    remove = true;
                    index++;
                } else {
                    cur++;
                    sum = 0;
                    max = 0;
                    remove = false;
                }
            } else {
                index++;
            }
        }
        return cur <= day;
    }

    private static int getMax(int[] ints) {
        int max = -1;
        int sum = 0;
        for (int cur : ints) {
            sum += cur;
            max = Math.max(max,cur);
        }
        return sum - max;
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(","))
                .mapToInt(Integer::parseInt).toArray();
    }
}
