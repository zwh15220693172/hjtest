package hjtest.B.hj36跳格子2;

import java.util.Objects;

public class LeeCode337 {

    public int rob(TreeNode root) {
        int[] result = getResult(root);
        return Math.max(result[0], result[1]);
    }

    private int[] getResult(TreeNode curNode) {
        if (Objects.isNull(curNode)) {
            return new int[2];
        }
        int[] left = getResult(curNode.left);
        int[] right = getResult(curNode.right);
        int val1 = curNode.val + left[1] + right[1];
        int val2 = Math.max(left[0],left[1]) + Math.max(right[0],right[1]);
        return new int[] {val1, val2};
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
