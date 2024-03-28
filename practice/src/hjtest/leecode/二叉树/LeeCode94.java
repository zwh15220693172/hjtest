package hjtest.leecode.二叉树;


import hjtest.data.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LeeCode94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode node, List<Integer> result) {
        if (Objects.isNull(node)) {
            return;
        }
        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
    }
}
