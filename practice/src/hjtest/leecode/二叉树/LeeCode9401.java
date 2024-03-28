package hjtest.leecode.二叉树;

import hjtest.data.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class LeeCode9401 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (Objects.isNull(root)) {
            return result;
        }
        Stack<TreeNode> cursor = new Stack<>();
        cursor.push(root);
        while (!cursor.isEmpty()) {
            TreeNode curNode = cursor.pop();
            result.add(curNode.val);
            if (Objects.nonNull(curNode.right)) {
                cursor.push(curNode.right);
            }
            if (Objects.nonNull(curNode.left)) {
                cursor.push(curNode.left);
            }
        }
        return result;
    }
}
