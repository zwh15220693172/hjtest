package hjtest.leecode.二叉树;

import hjtest.data.TreeNode;

public class LeeCode654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int index = findMaxIndex(nums);
        TreeNode node = new TreeNode(nums[index]);
        int[] left = buildArray(0, index, nums);
        node.left = constructMaximumBinaryTree(left);
        int[] right = buildArray(index+1, nums.length, nums);
        node.right = constructMaximumBinaryTree(right);
        return node;
    }

    private int[] buildArray(int start, int end, int[] nums) {
        if (start >= end) {
            return new int[0];
        }
        int len = end - start;
        int[] dp = new int[len];
        int index = 0;
        for (int i = start; i < end; i++) {
            dp[index++] = nums[i];
        }
        return dp;
    }

    private int findMaxIndex(int[] nums) {
        int index = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }
}
