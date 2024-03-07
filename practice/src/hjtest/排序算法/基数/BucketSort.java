package hjtest.排序算法.基数;

import 排序算法.SortDemo;

import java.util.Arrays;

public class BucketSort implements SortDemo {
    @Override
    public int[] sort(int[] elements) {
        int[][] bucket = new int[10][elements.length];
        int[] bucketIndex = new int[10];
        int count = count(elements);
        int divisor1 = 1;
        int divisor2 = 10;
        for (int i = 0; i < count; i++) {
            for (int cur : elements) {
                int index = cur % divisor2 / divisor1;
                bucket[index][bucketIndex[index]++] = cur;
            }
            int index = 0;
            for (int j = 0; j < bucket.length; j++) {
                int len = bucketIndex[j];
                for (int k = 0; k < len; k++) {
                    elements[index++] = bucket[j][k];
                    bucket[j][k] = 0;
                }
                bucketIndex[j] = 0;
            }
        }
        return elements;
    }

    private int count(int[] elements) {
        int num = Arrays.stream(elements).max().orElse(0);
        return String.valueOf(num).length();
    }
}
