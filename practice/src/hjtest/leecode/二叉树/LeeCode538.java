package hjtest.leecode.二叉树;

import hjtest.data.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LeeCode538 {
    public TreeNode convertBST(TreeNode root) {
        List<Integer> valList = new ArrayList<>();
        inorder(root, valList);
        resetNode(root, valList);
        return root;
    }

    private void resetNode(TreeNode node, List<Integer> valList) {
        if (Objects.isNull(node)) {
            return;
        }
        int cur = node.val;
        node.val = valList.stream().mapToInt(Integer::intValue).filter((val) -> val >= cur).sum();
        resetNode(node.left, valList);
        resetNode(node.right, valList);
    }

    private void inorder(TreeNode node, List<Integer> valList) {
        if (Objects.isNull(node)) {
            return;
        }
        inorder(node.left, valList);
        valList.add(node.val);
        inorder(node.right, valList);
    }
}
