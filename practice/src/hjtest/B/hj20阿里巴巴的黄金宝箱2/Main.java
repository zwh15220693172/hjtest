package hjtest.B.hj20阿里巴巴的黄金宝箱2;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] ints = getInts(input.nextLine());
            Map<Integer,Integer> numCount = new HashMap<>();
            for (int num : ints) {
                numCount.put(num,numCount.getOrDefault(num,0)+1);
            }
            int len = ints.length;
            int target = len / 2;
            int count = 0;
            List<NumCount> collect = numCount.entrySet().stream()
                    .map((entry) -> new NumCount(entry.getKey(), entry.getValue()))
                    .sorted(Comparator.comparing(NumCount::getCount).reversed())
                    .collect(Collectors.toList());
            for (NumCount cur : collect) {
                len-=cur.getCount();
                count++;
                if (len <= target) {
                    break;
                }
            }
            System.out.println(count);
        }
        input.close();
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
