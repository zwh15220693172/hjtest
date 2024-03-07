package hjtest.排序算法.选择.简单选择;

import hjtest.排序算法.SortDemo;

public class SelectSort implements SortDemo {
    @Override
    public int[] sort(int[] elements) {
        for (int i = 0; i < elements.length; i++) {
            int min = elements[i];
            int minIndex = i;
            for (int j = i + 1; j < elements.length; j++) {
                if (elements[j] < min) {
                    min = elements[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                elements[minIndex] = elements[i];
                elements[i] = min;
            }
        }
        return elements;
    }
}
