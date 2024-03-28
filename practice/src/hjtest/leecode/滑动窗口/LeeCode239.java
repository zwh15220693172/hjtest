package hjtest.leecode.滑动窗口;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeeCode239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        MaxUtil util = new MaxUtil();
        for (int i = 0; i < k; i++) {
            util.addLast(nums[i]);
        }
        int max = util.getMax();
        List<Integer> result = new ArrayList<>();
        result.add(max);
        for (int i = k; i < nums.length; i++) {
            util.removeFirst(nums[i-k]);
            util.addLast(nums[i]);
            result.add(util.getMax());
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private class MaxUtil {
        private final LinkedList<Integer> elements = new LinkedList<>();

        public void removeFirst(int num) {
            if (!elements.isEmpty() && num == elements.peek()) {
                elements.removeFirst();
            }
        }

        public void addLast(int num) {
            while (!elements.isEmpty() && num > elements.getLast()) {
                elements.removeLast();
            }
            elements.addLast(num);
        }

        public int getMax() {
            if (!elements.isEmpty()) {
                return elements.peek();
            }
            return -1;
        }
    }
}
