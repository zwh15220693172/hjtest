package hjtest.leecode.二叉树;

import hjtest.data.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LeeCode145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private void postorder(TreeNode node, List<Integer> result) {
        if (Objects.isNull(node)) {
            return;
        }
        postorder(node.left, result);
        postorder(node.right, result);
        result.add(node.val);
    }
}
