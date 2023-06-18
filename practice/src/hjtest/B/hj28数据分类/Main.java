package hjtest.B.hj28数据分类;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] ints = getInts(input.nextLine());
            int target = ints[0];
            int mod = ints[1];
            HashMap<Integer, Integer> numCount = new HashMap<>();
            for (int i = 2; i < ints.length; i++) {
                int sum = getSum(ints[i]);
                int result = sum % mod;
                if (result < target) {
                    numCount.put(result,numCount.getOrDefault(result,0)+1);
                }
            }
            Optional<NumCount> max = numCount.entrySet().stream().map((entry) -> new NumCount(entry.getKey(), entry.getValue()))
                    .max(Comparator.comparing(NumCount::getCount));
            if (max.isPresent()) {
                NumCount resultNumCount = max.get();
                System.out.println(resultNumCount.count);
            } else {
                System.out.println(0);
            }
        }
        input.close();
    }

    private static int getSum(int num) {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += (byte)(num >> (i * 8));
        }
        return sum;
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
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
