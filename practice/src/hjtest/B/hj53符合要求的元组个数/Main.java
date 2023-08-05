package hjtest.B.hj53符合要求的元组个数;

import java.util.*;

public class Main {
    private static final LinkedList<Integer> PATH = new LinkedList<>();
    private static int result;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            PATH.clear();
            result = 0;
            int[] ints = getInts(input.nextLine());
            int k = Integer.parseInt(input.nextLine());
            int target = Integer.parseInt(input.nextLine());
            int len = ints.length;
            boolean[] used = new boolean[len];
            getResult(0,k,0,target,0,ints,used);
            System.out.println(result);
        }
        input.close();
    }

    private static void getResult(int cur, int k, int sum, int target,
                                  int start, int[] ints, boolean[] used) {
        if (cur == k) {
            if (sum == target) {
                result++;
            }
            return;
        }
        for (int i = start; i < ints.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && ints[i] == ints[i-1] && !used[i-1]) {
                continue;
            }
            PATH.addLast(ints[i]);
            used[i] = true;
            getResult(cur+1,k,sum+ints[i],target,i+1,ints,used);
            PATH.removeLast();
            used[i] = false;
        }
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
    }
}
