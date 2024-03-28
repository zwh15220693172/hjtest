package hjtest.leecode.二叉树;

import hjtest.data.TreeNode;
import java.util.Objects;

public class LeeCode100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (Objects.isNull(p) && Objects.nonNull(q)) {
            return false;
        }
        if (Objects.nonNull(p) && Objects.isNull(q)) {
            return false;
        }
        if (Objects.isNull(p) && Objects.isNull(q)) {
            return true;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(p.right, q.right);
    }
}
