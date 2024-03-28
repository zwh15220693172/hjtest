package hjtest.leecode.二叉树;

import hjtest.data.TreeNode;
import java.util.Objects;

public class LeeCode111 {
    public int minDepth(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        if (Objects.isNull(root.left) && Objects.isNull(root.right)) {
            return 1;
        }
        if (Objects.isNull(root.left)) {
            return minDepth(root.right) + 1;
        }
        if (Objects.isNull(root.right)) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
