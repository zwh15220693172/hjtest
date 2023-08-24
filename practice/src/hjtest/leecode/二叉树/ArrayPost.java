package hjtest.leecode.二叉树;

import java.util.ArrayList;
import java.util.List;

public class ArrayPost {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        List<Integer> res = new ArrayList<>();
        postOrder(0,array,res);
        System.out.println(res);
    }

    private static void postOrder(int cur, int[] array, List<Integer> res) {
        int left = 2 * cur + 1;
        int right = 2 * cur + 2;
        if (array.length > left) {
            postOrder(left,array,res);
        }
        if (array.length > right) {
            postOrder(right,array,res);
        }
        res.add(array[cur]);
    }
}
