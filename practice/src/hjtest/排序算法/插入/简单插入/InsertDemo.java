package hjtest.排序算法.插入.简单插入;

import 排序算法.SortDemo;

public class InsertDemo implements SortDemo {
    @Override
    public int[] sort(int[] elements) {
        for (int i = 1; i < elements.length; i++) {
            int insertVal = elements[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertVal < elements[insertIndex]) {
                elements[insertIndex+1] = elements[insertIndex];
                insertIndex--;
            }
            elements[insertIndex+1] = insertVal;
        }
        return elements;
    }
}
