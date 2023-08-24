package hjtest.leecode.二叉树;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LeeCode14401 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preOrder(result,root);
        return result;
    }

    private void preOrder(List<Integer> result, TreeNode curNode) {
        if (Objects.isNull(curNode)) {
            return;
        }
        result.add(curNode.val);
        preOrder(result,curNode.left);
        preOrder(result,curNode.right);
    }
}
