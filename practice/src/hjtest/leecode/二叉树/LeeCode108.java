package hjtest.leecode.二叉树;

import hjtest.data.TreeNode;
import java.util.Arrays;

public class LeeCode108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        Arrays.sort(nums);
        int mid = nums.length / 2;
        TreeNode curNode = new TreeNode(nums[mid]);
        int[] left = getArray(0, mid, nums);
        curNode.left = sortedArrayToBST(left);
        int[] right = getArray(mid+1,nums.length,nums);
        curNode.right = sortedArrayToBST(right);
        return curNode;
    }

    private int[] getArray(int start, int end, int[] nums) {
        if (start >= end) {
            return new int[0];
        }
        int len = end - start;
        int[] newArray = new int[len];
        int index = 0;
        for (int i = start; i < end; i++) {
            newArray[index++] = nums[i];
        }
        return newArray;
    }
}
