package hjtest.B卷200分.hj06组成最大可靠性设备;

import java.util.*;

/**
 * 100%通过
 * 全排列回溯
 * 注意count = 0的情况
 * 如果没有符合要求的结果，要输出-1
 */
public class Main {
    private static final LinkedList<Machine> machines = new LinkedList<>();
    private static final List<MachineComposite> machineCompositeList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            machines.clear();
            machineCompositeList.clear();
            int[] totalLen = totalLen(input.nextLine());
            int total = totalLen[0];
            int len = totalLen[1];
            int count = Integer.parseInt(input.nextLine());
            HashMap<Integer,List<Machine>> typeMachine = buildTypeMachine(count,input);
            initMachineComposite(0,len,total,typeMachine);
            if (machineCompositeList.isEmpty()) {
                System.out.println(-1);
            } else {
                MachineComposite machineComposite = machineCompositeList.stream().max(Comparator.comparing(MachineComposite::getReliability)).get();
                System.out.println(machineComposite.reliability);
            }
        }
        input.close();
    }

    private static void initMachineComposite(int cur, int len, int total,
                                             HashMap<Integer, List<Machine>> typeMachine) {
        if (cur == len && !machines.isEmpty()) {
            int curTotal = machines.stream().mapToInt(Machine::getPrice).sum();
            int reliability = machines.stream().mapToInt(Machine::getReliability).min().getAsInt();
            if (curTotal <= total) {
                MachineComposite machineComposite = new MachineComposite(curTotal,reliability);
                machineCompositeList.add(machineComposite);
            }
            return;
        }
        if (!typeMachine.containsKey(cur)) {
            return;
        }
        List<Machine> curMachineList = typeMachine.get(cur);
        for (Machine machine : curMachineList) {
            machines.addLast(machine);
            initMachineComposite(cur+1,len,total,typeMachine);
            machines.removeLast();
        }
    }

    private static HashMap<Integer, List<Machine>> buildTypeMachine(int count, Scanner input) {
        HashMap<Integer,List<Machine>> typeMachine = new HashMap<>();
        while (count > 0) {
            String[] splits = input.nextLine().split(" ");
            int type = Integer.parseInt(splits[0]);
            int reliability = Integer.parseInt(splits[1]);
            int price = Integer.parseInt(splits[2]);
            List<Machine> list;
            if (typeMachine.containsKey(type)) {
                list = typeMachine.get(type);
            } else {
                list = new ArrayList<>();
                typeMachine.put(type,list);
            }
            Machine machine = new Machine(reliability,price);
            list.add(machine);
            count--;
        }
        return typeMachine;
    }

    private static int[] totalLen(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static class MachineComposite {
        private final int total;
        private final int reliability;

        public MachineComposite(int total, int reliability) {
            this.total = total;
            this.reliability = reliability;
        }

        public int getTotal() {
            return total;
        }

        public int getReliability() {
            return reliability;
        }
    }

    private static class Machine {
        private final int reliability;
        private final int price;

        public Machine(int reliability, int price) {
            this.reliability = reliability;
            this.price = price;
        }

        public int getReliability() {
            return reliability;
        }

        public int getPrice() {
            return price;
        }
    }
}
