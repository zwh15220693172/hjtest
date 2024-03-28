package hjtest.leecode.动态规划;

import hjtest.data.TreeNode;

import java.util.Objects;

public class LeeCode530 {
    private TreeNode pre;

    private int result = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return result;
    }

    private void inorder(TreeNode node) {
        if (Objects.isNull(node)) {
            return;
        }
        inorder(node.left);
        if (Objects.nonNull(pre)) {
            int cur = Math.abs(pre.val-node.val);
            result = Math.min(cur,result);
        }
        this.pre = node;
        inorder(node.right);
    }
}
