package hjtest.A.hj20最大的平分组个数;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int count = Integer.parseInt(input.nextLine());
            int[] ints = getInts(input.nextLine());
            Arrays.sort(ints);
            int[] minMaxSum = getMinMaxSum(ints);
            int min = minMaxSum[0];
            int max = minMaxSum[1];
            int sum = minMaxSum[2];
            for (int target = min; target <= max; target++) {
                if (sum % target != 0) {
                    continue;
                }
                int len = sum / target;
                if (canPut(target,len,ints)) {
                    System.out.println(len);
                    break;
                }
            }
        }
        input.close();
    }

    private static boolean canPut(int target, int len, int[] ints) {
        int[] bucket = new int[len];
        Arrays.fill(bucket, target);
        return putDetail(bucket,ints,ints.length-1);
    }

    private static boolean putDetail(int[] bucket, int[] ints, int index) {
        if (index < 0) {
            return true;
        }
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] == 0) {
                break;
            }
            if (bucket[i] == ints[index] || bucket[i] - ints[index] >= ints[0]) {
                bucket[i] -= ints[index];
                if (putDetail(bucket,ints,index-1)) {
                    return true;
                }
                bucket[i] += ints[index];
            }
        }
        return false;
    }

    private static int[] getMinMaxSum(int[] ints) {
        int min = Integer.MIN_VALUE;
        int sum = 0;
        for (int anInt : ints) {
            sum += anInt;
            min = Math.max(min,anInt);
        }
        int max = sum / 2;
        return new int[]{min, max, sum};
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
