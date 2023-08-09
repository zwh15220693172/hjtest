package hjtest.B卷100分.hj29乘坐保密电梯;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 注意事项：
 * 1.这个组合问题，不是全排列
 * 2.先排序
 * 3.如果可以等于target那么直接结束循环
 * 4.如果实在找不到等于target的那么只能用组合，求最优解
 * 没有100%通过，不过我知道是你的极限了
 */
public class Main {
    private static boolean getResult;
    private static List<Integer> resultList = new ArrayList<>();
    private static LinkedList<Integer> path = new LinkedList<>();
    private static int result;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            getResult = false;
            result = Integer.MAX_VALUE;
            resultList.clear();
            path.clear();
            int[] targetLen = targetLen(input.nextLine());
            int target = targetLen[0];
            int len = targetLen[1];
            int[] ints = getInts(input.nextLine());
            boolean[] used = new boolean[len];
            getResult(0,len,0,target,used,ints);
            String collect = resultList.stream().map(String::valueOf)
                    .collect(Collectors.joining(" "));
            System.out.println(collect);
        }
        input.close();
    }

    private static void getResult(int cursor, int len, int sum, int target, boolean[] used, int[] ints) {
        if (getResult) {
            return;
        }
        if (cursor == len) {
            if (sum == target) {
                resultList.clear();
                resultList = new ArrayList<>(path);
                getResult = true;
            } else if (Math.abs(sum - target) < Math.abs(result - target)) {
                result = sum;
                resultList.clear();
                resultList = new ArrayList<>(path);
            }
            return;
        }
        for (int i = 0; i < ints.length; i++) {
            if (used[i]) {
                continue;
            }
            path.addLast(ints[i]);
            used[i] = true;
            if (cursor % 2 == 0) {
                getResult(cursor+1,len,sum+ints[i],target,used,ints);
            } else {
                getResult(cursor+1,len,sum-ints[i],target,used,ints);
            }
            used[i] = false;
            path.removeLast();
        }
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .map(Integer::parseInt).sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue).toArray();
    }

    private static int[] targetLen(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
