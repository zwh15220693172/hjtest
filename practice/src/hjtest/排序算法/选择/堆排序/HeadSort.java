package hjtest.排序算法.选择.堆排序;


import hjtest.排序算法.SortDemo;

public class HeadSort implements SortDemo {

    @Override
    public int[] sort(int[] elements) {
        sortDetail(elements);
        return elements;
    }

    private void sortDetail(int[] elements) {
        for (int i = elements.length / 2 - 1; i >= 0; i--) {
            adjust(i, elements.length, elements);
        }
        for (int i = elements.length - 1; i > 0; i--) {
            int temp = elements[i];
            elements[i] = elements[0];
            elements[0] = temp;
            adjust(0, i,elements);
        }
    }

    private void adjust(int index, int len, int[] elements) {
        int temp = elements[index];
        for (int i = 2 * index + 1; i < len; i = 2 * i + 1) {
            if (i + 1 < len  && elements[i+1] > elements[i]) {
                i++;
            }
            if (elements[i] > temp) {
                elements[index] = elements[i];
                index = i;
            }
        }
        elements[index] = temp;
    }
}
