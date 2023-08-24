package hjtest.leecode.二叉树;

import java.util.ArrayList;
import java.util.List;

public class ArrayMid {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        List<Integer> res = new ArrayList<>();
        midOrder(0,array,res);
        System.out.println(res);
    }

    private static void midOrder(int cur, int[] array, List<Integer> res) {
        int left = 2 * cur + 1;
        int right = 2 * cur + 2;
        if (left < array.length) {
            midOrder(left,array,res);
        }
        res.add(array[cur]);
        if (right < array.length) {
            midOrder(right,array,res);
        }
    }
}
