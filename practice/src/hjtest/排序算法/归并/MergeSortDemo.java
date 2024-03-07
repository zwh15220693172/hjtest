package hjtest.排序算法.归并;

import 排序算法.SortDemo;

public class MergeSortDemo implements SortDemo {
    @Override
    public int[] sort(int[] elements) {
        int[] bucket = new int[elements.length];
        mergeSort(elements, 0, elements.length-1, bucket);
        return elements;
    }

    private void mergeSort(int[] elements, int left, int right, int[] bucket) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(elements,left,mid,bucket);
        mergeSort(elements,mid+1,right,bucket);
        merge(elements, left, mid, right, bucket);
    }

    private void merge(int[] elements, int start, int mid, int end, int[] bucket) {
        int left = start;
        int right = mid + 1;
        int index= 0;
        while (left <= mid && right <= end) {
            if (elements[left] < elements[right]) {
                bucket[index++] = elements[left++];
            } else {
                bucket[index++] = elements[right++];
            }
        }
        while (left <= mid) {
            bucket[index++] = elements[left++];
        }
        while (right <= end) {
            bucket[index++] = elements[right++];
        }
        index = 0;
        for (int i = start; i <= end; i++) {
            elements[i] = bucket[index++];
        }
    }
}
