package hjtest.leecode.二叉树;

import hjtest.data.TreeNode;

import java.util.Objects;

public class LeeCode617 {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return merge(root1, root2);
    }

    private TreeNode merge(TreeNode root1, TreeNode root2) {
        if (Objects.isNull(root1)) {
            return root2;
        }
        if (Objects.isNull(root2)) {
            return root1;
        }
        int val = root1.val + root2.val;
        TreeNode node = new TreeNode(val);
        node.left = merge(root1.left, root2.left);
        node.right = merge(root1.right, root2.right);
        return node;
    }
}
