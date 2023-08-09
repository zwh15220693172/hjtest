package hjtest.B卷100分.hj33计算最接近的数;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int i = line.lastIndexOf(",");
        int[] ints = Arrays.stream(line.substring(1, i - 1).split(",")).mapToInt(Integer::parseInt).toArray();
        int k = Integer.parseInt(line.substring(i + 1));
        System.out.println(getResult(ints, k));
    }

    private static int getResult(int[] ints, int k) {
        int target = getTarget(ints);
        int result = Integer.MAX_VALUE;
        int resultIndex = -1;
        for (int i = 0; i < ints.length; i++) {
            int cur = ints[i];
            int start = i + 1;
            int end = i + k - 1;
            if (start >= ints.length || end >= ints.length) {
                break;
            }
            for (int j = start; j <= end; j++) {
                cur -= ints[j];
            }
            if (Math.abs(cur-target) < Math.abs(result-target)) {
                result = cur;
                resultIndex = i;
            } else if (Math.abs(cur-target) == Math.abs(result-target)) {
                resultIndex = i;
            }
        }
        return resultIndex;
    }

    private static int getTarget(int[] ints) {
        int[] cursor = new int[ints.length];
        int len = cursor.length / 2;
        System.arraycopy(ints,0,cursor,0,ints.length);
        Arrays.sort(cursor);
        return cursor[len];
    }
}
