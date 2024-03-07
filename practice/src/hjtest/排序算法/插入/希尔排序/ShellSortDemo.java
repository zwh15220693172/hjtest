package hjtest.排序算法.插入.希尔排序;

import 排序算法.SortDemo;

public class ShellSortDemo implements SortDemo {
    @Override
    public int[] sort(int[] elements) {
        for (int grep = elements.length / 2; grep > 0; grep /= 2) {
            for (int i = grep; i < elements.length; i++) {
                int insertVal = elements[i];
                int insertIndex = i - grep;
                while (insertIndex >= 0 && insertVal < elements[insertIndex]) {
                    elements[insertIndex+grep] = elements[insertIndex];
                    insertIndex-=grep;
                }
                elements[insertIndex+grep] = insertVal;
            }
        }
        return elements;
    }
}
