package hjtest.leecode.二叉树;

import hjtest.data.TreeNode;
import java.util.Objects;

public class LeeCode104 {
    public int maxDepth(TreeNode root) {
        return getMaxDepth(root);
    }

    private int getMaxDepth(TreeNode curNode) {
        if (Objects.isNull(curNode)) {
            return 0;
        }
        if (Objects.isNull(curNode.left) && Objects.isNull(curNode.right)) {
            return 1;
        }
        return Math.max(getMaxDepth(curNode.left), getMaxDepth(curNode.right)) + 1;
    }
}
