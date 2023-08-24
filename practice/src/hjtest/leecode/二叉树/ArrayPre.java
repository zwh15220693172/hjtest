package hjtest.leecode.二叉树;

import java.util.ArrayList;
import java.util.List;

public class ArrayPre {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        List<Integer> res = new ArrayList<>();
        preOrder(0,array,res);
        System.out.println(res);
    }

    private static void preOrder(int cur, int[] array, List<Integer> res) {
        res.add(array[cur]);
        int left = 2 * cur + 1;
        int right = 2 * cur + 2;
        if (left < array.length) {
            preOrder(left,array,res);
        }
        if (right < array.length) {
            preOrder(right,array,res);
        }
    }
}
