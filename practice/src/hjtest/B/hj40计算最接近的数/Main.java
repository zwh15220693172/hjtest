package hjtest.B.hj40计算最接近的数;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] params = getParams(input.nextLine());
            int[] ints = getInts(params);
            int k = params[params.length-1];
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
                if (Math.abs(cur - target) <= Math.abs(result-target)) {
                    result = cur;
                    resultIndex = i;
                }
            }
            System.out.println(resultIndex);
        }
        input.close();
    }

    private static int getTarget(int[] ints) {
        int[] cursor = new int[ints.length];
        System.arraycopy(ints,0,cursor,0,ints.length);
        Arrays.sort(cursor);
        int len = cursor.length / 2;
        return cursor[len];
    }

    private static int[] getInts(int[] params) {
        int[] ints = new int[params.length-1];
        System.arraycopy(params,0,ints,0,params.length-1);
        return ints;
    }

    private static int[] getParams(String nextLine) {
        String replace = nextLine.replace("[", "").replace("]", "");
        return Arrays.stream(replace.split(",")).mapToInt(Integer::parseInt).toArray();
    }
}
