package hjtest.B.hj25找出两个整数数组中同时出现的整数;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] ints01 = getInts(input.nextLine());
            int[] ints02 = getInts(input.nextLine());
            HashMap<Integer,Integer> map1 = getMap(ints01);
            HashMap<Integer,Integer> map2 = getMap(ints02);
            List<NumCount> listNumCount = listNumCount(map1, map2);
            HashMap<Integer,List<Integer>> resultMap = new HashMap<>();
            listNumCount.sort(Comparator.comparing(NumCount::getCount));
            for (NumCount numCount : listNumCount) {
                int count = numCount.count;
                int num = numCount.num;
                List<Integer> list;
                if (resultMap.containsKey(count)) {
                    list = resultMap.get(count);
                } else {
                    list = new ArrayList<>();
                    resultMap.put(count,list);
                }
                list.add(num);
            }
            if (resultMap.isEmpty()) {
                System.out.println("NULL");
            } else {
                resultMap.forEach((key,list)->{
                    String result = key + ":";
                    String collect = list.stream().map(String::valueOf).collect(Collectors.joining(","));
                    System.out.println(result + collect);
                });
            }
        }
        input.close();
    }

    private static List<NumCount> listNumCount(HashMap<Integer, Integer> map1, HashMap<Integer, Integer> map2) {
        Set<Integer> keys = map1.keySet();
        List<NumCount> listNumCount = new ArrayList<>();
        for (Integer key : keys) {
            if (map2.containsKey(key)) {
                int num = key;
                int count1 = map1.get(key);
                int count2 = map2.get(key);
                int count = Math.min(count1,count2);
                NumCount numCount = new NumCount(num,count);
                listNumCount.add(numCount);
            }
        }
        return listNumCount;
    }

    private static HashMap<Integer, Integer> getMap(int[] ints01) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : ints01) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        return map;
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(","))
                .mapToInt(Integer::parseInt).toArray();
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
