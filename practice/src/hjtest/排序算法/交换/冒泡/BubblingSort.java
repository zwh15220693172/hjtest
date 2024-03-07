package hjtest.排序算法.交换.冒泡;

import 排序算法.SortDemo;

public class BubblingSort implements SortDemo {
    @Override
    public int[] sort(int[] elements) {
        for (int i = 0; i < elements.length; i++) {
            boolean change = false;
            for (int j = 0; j < elements.length - i - 1; j++) {
                if (elements[j] > elements[j+1]) {
                    int temp = elements[j];
                    elements[j] = elements[j+1];
                    elements[j+1] = temp;
                    change = true;
                }
            }
            if (!change) {
                break;
            }
        }
        return elements;
    }
}
