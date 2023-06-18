package hjtest.B.hj24组装最大可靠性设备;

import java.util.*;

public class Main {
    private static final List<Machine> listMachine = new ArrayList<>();
    private static final LinkedList<MachinePart> listMachinePart = new LinkedList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            listMachine.clear();
            listMachinePart.clear();
            int[] totalLenInts = getInts(input.nextLine());
            int total = totalLenInts[0];
            int len = totalLenInts[1];
            int count = Integer.parseInt(input.nextLine());
            HashMap<Integer, List<MachinePart>> partMap = getPartMap(count, input);
            backtracking(0,len,total,partMap);
            Optional<Machine> max = listMachine.stream().max(Comparator.comparing(Machine::getVal));
            if (max.isPresent()) {
                Machine machine = max.get();
                System.out.println(machine.val);
            } else {
                System.out.println(-1);
            }
        }
        input.close();
    }

    private static void backtracking(int index, int len, int total, HashMap<Integer, List<MachinePart>> partMap) {
        if (index == len) {
            int val = Integer.MAX_VALUE;
            int cost = 0;
            for (MachinePart machinePart : listMachinePart) {
                cost += machinePart.cost;
                val = Math.min(val,machinePart.val);
            }
            Machine machine = new Machine(val, cost);
            if (cost <= total) {
                listMachine.add(machine);
            }
            return;
        }
        List<MachinePart> machineParts = partMap.get(index);
        for (MachinePart machinePart : machineParts) {
            listMachinePart.addLast(machinePart);
            backtracking(index+1,len,total,partMap);
            listMachinePart.removeLast();
        }
    }

    private static HashMap<Integer, List<MachinePart>> getPartMap(int count, Scanner input) {
        HashMap<Integer,List<MachinePart>> map = new HashMap<>();
        while (count > 0) {
            int[] ints = Arrays.stream(input.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int code = ints[0];
            int val = ints[1];
            int cost = ints[2];
            MachinePart machinePart = new MachinePart(code,val,cost);
            if (map.containsKey(code)) {
                List<MachinePart> machineParts = map.get(code);
                machineParts.add(machinePart);
            } else {
                List<MachinePart> list = new ArrayList<>();
                list.add(machinePart);
                map.put(code,list);
            }
            count--;
        }
        return map;
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static class MachinePart {
        private final int code;
        private final int val;
        private final int cost;

        public MachinePart(int code, int val, int cost) {
            this.code = code;
            this.val = val;
            this.cost = cost;
        }

        public int getCode() {
            return code;
        }

        public int getVal() {
            return val;
        }

        public int getCost() {
            return cost;
        }
    }

    private static class Machine {
        private final int val;
        private final int cost;

        public Machine(int val, int cost) {
            this.val = val;
            this.cost = cost;
        }

        public int getVal() {
            return val;
        }

        public int getCost() {
            return cost;
        }
    }
}
