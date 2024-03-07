package hjtest.排序算法;

import hjtest.排序算法.选择.堆排序.HeadSort;

import java.util.Arrays;

public class TestDemo {
    public static void main(String[] args) {
        int[] elements = {1,10,21,2,3,6,11,31,23,98,76,123,5};
        SortDemo sortDemo = new HeadSort();
        sortDemo.sort(elements);
        System.out.println(Arrays.toString(elements));
    }
}
