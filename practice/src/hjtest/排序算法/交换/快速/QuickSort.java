package hjtest.排序算法.交换.快速;

import 排序算法.SortDemo;

public class QuickSort implements SortDemo {
    @Override
    public int[] sort(int[] elements) {
        quickSort(0,elements.length-1,elements);
        return elements;
    }

    private void quickSort(int start, int end, int[] elements) {
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int pivot = elements[left];
        while (left < right) {
            while (left < right && elements[right] >= pivot) {
                right--;
            }
            elements[left] = elements[right];
            while (left < right && elements[left] <= pivot) {
                left++;
            }
            elements[right] = elements[left];
            if (left == right) {
                elements[left] = pivot;
            }
        }
        quickSort(start,left-1,elements);
        quickSort(left+1,end,elements);
    }
}
