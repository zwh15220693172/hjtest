package hjtest.leecode.二叉树;

import hjtest.data.TreeNode;

import java.util.Objects;

public class LeeCode226 {
    public TreeNode invertTree(TreeNode root) {
        if (Objects.isNull(root)) {
            return root;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
