package hjtest.leecode.二叉树.二叉搜索树;

import hjtest.data.TreeNode;

import java.util.Objects;

/**
 * BST插入操作
 */
public class LeeCode701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (Objects.isNull(root)) {
            return new TreeNode(val);
        }
        insertLogic(root, val);
        return root;
    }

    private void insertLogic(TreeNode node, int val) {
        if (Objects.isNull(node)) {
            return;
        }
        int cur = node.val;
        if (val > cur) {
            if (Objects.isNull(node.right)) {
                node.right = new TreeNode(val);
            } else {
                insertLogic(node.right, val);
            }
        } else {
            if (Objects.isNull(node.left)) {
                node.left = new TreeNode(val);
            } else {
                insertLogic(node.left, val);
            }
        }
    }
}
