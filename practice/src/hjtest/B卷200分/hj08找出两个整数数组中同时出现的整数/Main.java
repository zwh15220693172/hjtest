package hjtest.B卷200分.hj08找出两个整数数组中同时出现的整数;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] ints01 = getInts(input.nextLine());
        int[] ints02 = getInts(input.nextLine());
        Map<Integer,Integer> numCount01 = buildNumCount(ints01);
        Map<Integer,Integer> numCount02 = buildNumCount(ints02);
        List<NumCount> result = new ArrayList<>();
        Set<Integer> keys = numCount01.keySet();
        for (Integer key : keys) {
            if (!numCount02.containsKey(key)) {
                continue;
            }
            int val01 = numCount01.get(key);
            int val02 = numCount02.get(key);
            int val = Math.min(val01,val02);
            NumCount numCount = new NumCount(key,val);
            result.add(numCount);
        }
        if (result.isEmpty()) {
            System.out.println("NULL");
        } else {
            Map<Integer, List<NumCount>> collect = result.stream().collect(Collectors.groupingBy(NumCount::getCount));
            collect.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach((entry)->{
                int key = entry.getKey();
                String values = entry.getValue().stream().map(NumCount::getNum).sorted()
                        .map(String::valueOf).collect(Collectors.joining(","));
                System.out.println(key+":"+values);
            });
        }
    }

    private static Map<Integer, Integer> buildNumCount(int[] ints) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int cur : ints) {
            map.put(cur,map.getOrDefault(cur,0)+1);
        }
        return map;
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(","))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
    }

    private static class NumCount {
        private final int num;
        private final int count;

        public NumCount(int num, int count) {
            this.num = num;
            this.count = count;
        }

        public int getNum() {
            return num;
        }

        public int getCount() {
            return count;
        }
    }
}
