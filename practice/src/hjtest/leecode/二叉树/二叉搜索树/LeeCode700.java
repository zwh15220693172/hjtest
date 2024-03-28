package hjtest.leecode.二叉树.二叉搜索树;

import hjtest.data.TreeNode;

import java.util.Objects;


public class LeeCode700 {
    public TreeNode searchBST(TreeNode root, int val) {
        return searchDetail(root, val);
    }

    private TreeNode searchDetail(TreeNode node, int val) {
        if (Objects.isNull(node)) {
            return node;
        }
        int cur = node.val;
        if (cur == val) {
            return node;
        }
        if (cur < val) {
            return searchDetail(node.right, val);
        } else {
            return searchDetail(node.left, val);
        }
    }
}
