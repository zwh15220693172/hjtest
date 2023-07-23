package hjtest.B.hj39乘坐保密电梯;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final LinkedList<Integer> path = new LinkedList<>();
    private static final List<List<Integer>> result = new ArrayList<>();
    private static boolean getResult;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            path.clear();
            result.clear();
            getResult = false;
            int[] params = getParams(input.nextLine());
            int[] ints = getInts(input.nextLine());
            boolean[] used = new boolean[ints.length];
            int target = params[0];
            int maxLen = params[1];
            getResult(0,maxLen,0,target,ints,used);
            List<Integer> integers = result.get(0);
            String collect = integers.stream().map(String::valueOf).collect(Collectors.joining(" "));
            System.out.println(collect);
        }
        input.close();
    }

    private static void getResult(int len, int maxLen, int cur, int target, int[] ints, boolean[] used) {
        if (getResult) {
            return;
        }
        if (len == maxLen) {
            if (cur == target) {
                result.add(new ArrayList<>(path));
                getResult = true;
            }
            return;
        }
        for (int i = 0; i < ints.length; i++) {
            if (getResult) {
                break;
            }
            if (used[i]) {
                continue;
            }
            path.addLast(ints[i]);
            used[i] = true;
            if (len % 2 == 0) {
                getResult(len+1,maxLen,cur+ints[i],target,ints, used);
            } else {
                getResult(len+1,maxLen,cur-ints[i],target,ints, used);
            }
            used[i] = false;
            path.removeLast();
        }
    }

    private static int[] getParams(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .map(Integer::parseInt)
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue).toArray();
    }
}
