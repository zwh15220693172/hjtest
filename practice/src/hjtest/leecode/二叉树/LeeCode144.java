package hjtest.leecode.二叉树;

import hjtest.data.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LeeCode144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preOrder(root, result);
        return result;
    }

    private void preOrder(TreeNode node, List<Integer> result) {
        if (Objects.isNull(node)) {
            return;
        }
        result.add(node.val);
        preOrder(node.left, result);
        preOrder(node.right, result);
    }
}
