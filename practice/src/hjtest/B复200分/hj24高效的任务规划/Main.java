package hjtest.B复200分.hj24高效的任务规划;

import java.util.*;

/**
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextInt()) {
            int taskNum = input.nextInt();
            List<Integer> result = new ArrayList<>();
            while (taskNum > 0) {
                int resultAlone = getResultAlone(input);
                result.add(resultAlone);
                taskNum--;
            }
            result.forEach(System.out::println);
        }
        input.close();
    }

    private static int getResultAlone(Scanner input) {
        int machineNum = input.nextInt();
        int[][] machineList = new int[machineNum][2];
        int index = 0;
        while (machineNum > 0) {
            int workTime = input.nextInt();
            int holdTime = input.nextInt();
            int[] machine = new int[]{workTime,holdTime};
            machineList[index++] = machine;
            machineNum--;
        }
        Arrays.sort(machineList, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] == b[1]) {
                    return b[0] - a[0];
                }
                return b[1] - a[1];
            }
        });
        int total = 0;
        for (int[] ints : machineList) {
            total += ints[0];
        }
        int cursor = total;
        int max = 0;
        for (int[] ints : machineList) {
            cursor-=ints[0];
            if (ints[1] > cursor) {
                int cur = ints[1] - cursor;
                max = Math.max(cur,max);
            }
        }
        return total + max;
    }
}
