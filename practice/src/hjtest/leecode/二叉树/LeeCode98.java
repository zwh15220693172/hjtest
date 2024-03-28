package hjtest.leecode.二叉树;

import hjtest.data.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class LeeCode98 {
    public boolean isValidBST(TreeNode root) {
        List<Integer> elements = new ArrayList<>();
        inorder(elements, root);
        return validBst(elements);
    }

    private boolean validBst(List<Integer> elements) {
        Stack<Integer> cursor = new Stack<>();
        for (Integer element : elements) {
            if (!cursor.isEmpty() && element <= cursor.pop()) {
                return false;
            }
            cursor.push(element);
        }
        return true;
    }

    private void inorder(List<Integer> elements, TreeNode node) {
        if (Objects.isNull(node)) {
            return;
        }
        inorder(elements, node.left);
        elements.add(node.val);
        inorder(elements, node.right);
    }
}
