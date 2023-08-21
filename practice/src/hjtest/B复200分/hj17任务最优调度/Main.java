package hjtest.B复200分.hj17任务最优调度;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] ints = getInts(input.nextLine());
            HashMap<Integer,Integer> numCount = buildNumCount(ints);
            int n = Integer.parseInt(input.nextLine());
            int k = getK(numCount);
            int p = getP(numCount,k);
            int cur = (k-1)*(n+1)+p;
            int result = Math.max(cur, ints.length);
            System.out.println(result);
        }
        input.close();
    }

    private static int getP(HashMap<Integer, Integer> numCount, int k) {
        int count = 0;
        Collection<Integer> values = numCount.values();
        for (int value : values) {
            if (value == k) {
                count++;
            }
        }
        return count;
    }

    private static int getK(HashMap<Integer, Integer> numCount) {
        int max = Integer.MIN_VALUE;
        Collection<Integer> values = numCount.values();
        for (int count : values) {
            max = Math.max(count,max);
        }
        return max;
    }

    private static HashMap<Integer, Integer> buildNumCount(int[] ints) {
        HashMap<Integer,Integer> numCount = new HashMap<>();
        for (int anInt : ints) {
            numCount.put(anInt,numCount.getOrDefault(anInt,0)+1);
        }
        return numCount;
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(","))
                .mapToInt(Integer::parseInt).toArray();
    }
}
