package hjtest.leecode.二叉树;

import hjtest.data.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LeeCode572 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        List<TreeNode> targetList = new ArrayList<>();
        findTarget(root, subRoot.val, targetList);
        if (targetList.isEmpty()) {
            return false;
        }
        for (TreeNode target : targetList) {
            if (sameRoot(target, subRoot)) {
                return true;
            }
        }
        return false;
    }

    private void findTarget(TreeNode node, int val, List<TreeNode> targetList) {
        if (Objects.isNull(node)) {
            return;
        }
        if  (node.val == val) {
            targetList.add(node);
        }
        findTarget(node.left, val, targetList);
        findTarget(node.right,val, targetList);
    }

    private boolean sameRoot(TreeNode target, TreeNode subRoot) {
        if (Objects.isNull(target) && Objects.nonNull(subRoot)) {
            return false;
        }
        if (Objects.nonNull(target) && Objects.isNull(subRoot)) {
            return false;
        }
        if (Objects.isNull(target)) {
            return true;
        }
        if (target.val != subRoot.val) {
            return false;
        }
        return sameRoot(target.left, subRoot.left) && sameRoot(target.right, subRoot.right);
    }
}
