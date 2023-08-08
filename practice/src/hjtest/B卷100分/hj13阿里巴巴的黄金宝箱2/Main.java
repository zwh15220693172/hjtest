package hjtest.B卷100分.hj13阿里巴巴的黄金宝箱2;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] ints = getInts(input.nextLine());
            HashMap<Integer, DigitCount> digitCountMap = digitCount(ints);
            int result = 0;
            int len = ints.length;
            int target = len / 2;
            List<DigitCount> collect = digitCountMap.values().stream().sorted(new Comparator<DigitCount>() {
                @Override
                public int compare(DigitCount a, DigitCount b) {
                    return b.count - a.count;
                }
            }).collect(Collectors.toList());
            for (DigitCount digitCount : collect) {
                if (len <= target) {
                    break;
                }
                len -= digitCount.count;
                result++;
            }
            System.out.println(result);
        }
        input.close();
    }

    private static HashMap<Integer, DigitCount> digitCount(int[] ints) {
        HashMap<Integer,DigitCount> digitCount = new HashMap<>();
        for (int num : ints) {
            DigitCount count;
            if (digitCount.containsKey(num)) {
                count = digitCount.get(num);
            } else {
                count = new DigitCount(num);
                digitCount.put(num,count);
            }
            count.add();
        }
        return digitCount;
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(","))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
    }

    private static class DigitCount {
        private final int digit;
        private int count;

        public DigitCount(int digit) {
            this.digit = digit;
        }

        public void add() {
            count++;
        }
    }
}
