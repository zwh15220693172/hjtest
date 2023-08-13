package hjtest.B卷200分.hj13数字游戏;

import java.util.*;

/**
 * 100%通过
 * 一个数，定义为cur
 * 先加上数组内的数，然后再%target
 * int[] dp = new int[target]
 * 如果dp[cur] = 1那么我们有连续的解
 * 记住每次除完之后，如果没有得到结果，那么dp[cur] = 1的初始化操作
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (input.hasNextLine()) {
            String lenTargetStr = input.nextLine();
            if (lenTargetStr.isEmpty()) {
                break;
            }
            int[] lenTarget = getInts(lenTargetStr);
            int len = lenTarget[0];
            int target = lenTarget[1];
            int[] ints = getInts(input.nextLine());
            int[] result = new int[target];
            result[0] = 1;
            int cur = 0;
            boolean getResult = false;
            for (int i = 0; i < ints.length; i++) {
                cur += ints[i];
                cur %= target;
                if (result[cur] == 1) {
                    getResult = true;
                    break;
                } else {
                    result[cur] = 1;
                }
            }
            if (getResult) {
                list.add(1);
            } else {
                list.add(0);
            }
        }
        list.forEach(System.out::println);
        input.close();
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
