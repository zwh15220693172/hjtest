package hjtest.B卷200分.hj06组成最大可靠性设备;

import java.util.*;

/**
 * 100%通过
 * 全排列回溯
 * 注意count = 0的情况
 * 如果没有符合要求的结果，要输出-1
 */
public class Main {

    private static int result;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        result = -1;
        int total = input.nextInt();
        int len = input.nextInt();
        HashMap<Integer, List<Machine>> map = buildMap(input);
        backtracking(0,len,0,total,Integer.MAX_VALUE,map);
        System.out.println(result);
    }

    private static void backtracking(int cur, int len, int sum, int total, int reliability,
                                     HashMap<Integer, List<Machine>> map) {
        if (cur == len) {
            if (sum <= total && reliability != Integer.MAX_VALUE) {
                result = Math.max(reliability,result);
            }
            return;
        }
        if (!map.containsKey(cur)) {
            return;
        }
        List<Machine> machines = map.get(cur);
        for (Machine machine : machines) {
            if (machine.price > total || machine.price + sum > total) {
                continue;
            }
            backtracking(cur+1,len,sum+machine.price,total,Math.min(reliability,machine.reliability),map);
        }
    }

    private static HashMap<Integer, List<Machine>> buildMap(Scanner input) {
        int count = input.nextInt();
        HashMap<Integer, List<Machine>> map = new HashMap<>();
        while (count > 0) {
            int id = input.nextInt();
            int reliability = input.nextInt();
            int price = input.nextInt();
            List<Machine> list;
            if (map.containsKey(id)) {
                list = map.get(id);
            } else {
                list = new ArrayList<>();
                map.put(id,list);
            }
            list.add(new Machine(id,reliability,price));
            count--;
        }
        return map;
    }

    private static class Machine {
        private int id;
        private int reliability;
        private int price;

        public Machine(int id, int reliability, int price) {
            this.id = id;
            this.reliability = reliability;
            this.price = price;
        }
    }
}
