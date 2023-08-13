package hjtest.B卷200分.hj14跳房子;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 三数之和记录下标版本
 * 值得注意的一个地方是
 * 因为我是根据index进行从小到大排序的
 * 因此在找到结果后，只需要right--就可以了
 * 因为right先找到大的那个
 * left已经是小的那个了
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] ints = getInts(input.nextLine());
            int target = Integer.parseInt(input.nextLine());
            NumIndex[] numIndices = listNumberIndex(ints);
            int indexSum = Integer.MAX_VALUE;
            int[] result = new int[3];
            for (int i = 0; i < numIndices.length; i++) {
                if (i > 0 && numIndices[i].number == numIndices[i-1].number) {
                    continue;
                }
                int left = i + 1;
                int right = numIndices.length - 1;
                while (left < right) {
                    int cur = numIndices[i].number+numIndices[left].number+numIndices[right].number;
                    if (cur < target) {
                        left++;
                    } else if (cur > target) {
                        right--;
                    } else {
                        if (numIndices[i].index + numIndices[left].index + numIndices[right].index < indexSum) {
                            indexSum = numIndices[i].index + numIndices[left].index + numIndices[right].index;
                            result = Stream.of(numIndices[i],numIndices[left],numIndices[right])
                                    .sorted(Comparator.comparing(NumIndex::getIndex))
                                    .mapToInt(NumIndex::getNumber).toArray();
                        }
                        right--;
                    }
                }
            }
            String collect = Arrays.stream(result).mapToObj(String::valueOf)
                    .collect(Collectors.joining(","));
            System.out.println("["+collect+"]");
        }
        input.close();
    }

    private static NumIndex[] listNumberIndex(int[] ints) {
        List<NumIndex> list = new ArrayList<>();
        for (int i = 0; i < ints.length; i++) {
            list.add(new NumIndex(ints[i], i));
        }
        return list.stream().sorted(new Comparator<NumIndex>() {
            @Override
            public int compare(NumIndex a, NumIndex b) {
                if (a.number == b.number) {
                    return a.index - b.index;
                }
                return a.number - b.number;
            }
        }).toArray(NumIndex[]::new);
    }

    private static int[] getInts(String nextLine) {
        String replace = nextLine.replaceAll("\\[", "").replaceAll("]", "");
        return Arrays.stream(replace.split(","))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static class NumIndex {
        private final int number;
        private final int index;

        public NumIndex(int number, int index) {
            this.number = number;
            this.index = index;
        }

        public int getNumber() {
            return number;
        }

        public int getIndex() {
            return index;
        }
    }
}
