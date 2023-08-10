package hjtest.B卷200分.hj08找出两个整数数组中同时出现的整数;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 两个数组整成两个hashMap, key: number value: count
 * 第一个hashMap的key去给第二个hashmap做判断，如果包含，那么放进list里面去
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] ints01 = getInts(input.nextLine());
            HashMap<Integer, Integer> numCount01 = buildNumCountMap(ints01);
            int[] ints02 = getInts(input.nextLine());
            HashMap<Integer, Integer> numCount02 = buildNumCountMap(ints02);
            List<NumberCount> resultList = new ArrayList<>();
            for (int key : numCount01.keySet()) {
                if (numCount02.containsKey(key)) {
                    int count01 = numCount01.get(key);
                    int count02 = numCount02.get(key);
                    int count = Math.min(count01,count02);
                    NumberCount numberCount = new NumberCount(key,count);
                    resultList.add(numberCount);
                }
            }
            if (resultList.isEmpty()) {
                System.out.println("NULL");
            } else {
                getResult(resultList);
            }
        }
        input.close();
    }

    private static void getResult(List<NumberCount> resultList) {
        Map<Integer, List<NumberCount>> collect = resultList.stream().collect(Collectors.groupingBy(NumberCount::getCount));
        collect.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach((entry)->{
            int count = entry.getKey();
            String values = entry.getValue().stream().map(NumberCount::getNumber).sorted()
                    .map(String::valueOf).collect(Collectors.joining(","));
            System.out.println(count + ":" + values);
        });
    }

    private static HashMap<Integer,Integer> buildNumCountMap(int[] ints01) {
        HashMap<Integer,Integer> numCount = new HashMap<>();
        int[] target = new int[ints01.length+1];
        target[target.length-1] = Integer.MAX_VALUE;
        System.arraycopy(ints01,0,target,0,ints01.length);
        int pre = target[0];
        int count = 1;
        for (int i = 1; i < target.length; i++) {
            if (target[i] == pre) {
                count++;
            } else {
                numCount.put(pre,count);
                pre = target[i];
                count = 1;
            }
        }
        return numCount;
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(","))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
    }

    private static class NumberCount {
        private final int number;
        private final int count;

        public NumberCount(int number, int count) {
            this.number = number;
            this.count = count;
        }

        public int getNumber() {
            return number;
        }

        public int getCount() {
            return count;
        }
    }
}
