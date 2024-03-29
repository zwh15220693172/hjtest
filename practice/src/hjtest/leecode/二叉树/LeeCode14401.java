package hjtest.leecode.二叉树;

import hjtest.data.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class LeeCode14401 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (Objects.isNull(root)) {
            return result;
        }
        Stack<TreeNode> cursor = new Stack<>();
        TreeNode curNode = root;
        while (Objects.nonNull(curNode) || !cursor.isEmpty()) {
            while (Objects.nonNull(curNode)) {
                cursor.push(curNode);
                curNode = curNode.left;
            }
            curNode = cursor.pop();
            result.add(curNode.val);
            curNode = curNode.right;
        }
        return result;
    }
}
