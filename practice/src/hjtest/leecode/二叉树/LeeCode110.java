package hjtest.leecode.二叉树;

import hjtest.data.TreeNode;
import java.util.Objects;

public class LeeCode110 {
    public boolean isBalanced(TreeNode root) {
        if (Objects.isNull(root)) {
            return true;
        }
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        if (Math.abs(left - right) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode node) {
        if (Objects.isNull(node)) {
            return 0;
        }
        if (Objects.isNull(node.left) && Objects.isNull(node.right)) {
            return 1;
        }
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }
}
