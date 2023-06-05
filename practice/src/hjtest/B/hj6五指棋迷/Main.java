package hjtest.B.hj6五指棋迷;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int target = Integer.parseInt(input.nextLine());
            int[] ints = getInts(input.nextLine());
            List<Integer> zeroIndexList = getZeroIndex(ints);
            int mid = ints.length / 2;
            List<ZeroMax> collect = listZeroMax(zeroIndexList, target, mid, ints);
            ZeroMax zeroMax = collect.get(0);
            System.out.println(zeroMax.index);
        }
        input.close();
    }

    private static List<ZeroMax> listZeroMax(List<Integer> zeroIndexList, int target, int mid, int[] ints) {
        return zeroIndexList.stream().map((index) -> mapperToZeroMax(index, target, ints))
                .sorted(new Comparator<ZeroMax>() {
                    @Override
                    public int compare(ZeroMax a, ZeroMax b) {
                        if (a.max == b.max) {
                            int aSplit = Math.abs(a.index - mid);
                            int bSplit = Math.abs(b.index - mid);
                            if (aSplit == bSplit) {
                                return a.index - b.index;
                            }
                            return aSplit - bSplit;
                        } else {
                            return b.max - a.max;
                        }
                    }
                }).collect(Collectors.toList());
    }

    private static ZeroMax mapperToZeroMax(int index, int target, int[] ints) {
        ints[index] = target;
        int max = getMax(ints, target);
        ints[index] = 0;
        return new ZeroMax(index,max);
    }

    private static List<Integer> getZeroIndex(int[] ints) {
        List<Integer> zeroIndexList = new ArrayList<>();
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == 0) {
                zeroIndexList.add(i);
            }
        }
        return zeroIndexList;
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static int getMax(int[] ints, int target) {
        int count = 0;
        int maxCount = 1;
        for (int anInt : ints) {
            if (anInt == target) {
                count++;
                maxCount = Math.max(count, maxCount);
            } else {
                count = 0;
            }
        }
        return maxCount;
    }

    private static class ZeroMax {
        private int index;
        private int max;

        public ZeroMax(int index, int max) {
            this.index = index;
            this.max = max;
        }

        public int getIndex() {
            return index;
        }

        public int getMax() {
            return max;
        }
    }
}
