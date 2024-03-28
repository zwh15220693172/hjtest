package hjtest.leecode.二叉树;

import hjtest.data.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class LeeCode14501 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (Objects.isNull(root)) {
            return result;
        }
        Stack<TreeNode> cursor = new Stack<>();
        cursor.push(root);
        while (!cursor.isEmpty()) {
            TreeNode curNode = cursor.pop();
            result.add(curNode.val);
            if (Objects.nonNull(curNode.left)) {
                cursor.push(curNode.left);
            }
            if (Objects.nonNull(curNode.right)) {
                cursor.push(curNode.right);
            }
        }
        return reserve(result);
    }

    private List<Integer> reserve(List<Integer> result) {
        int left = 0;
        int right = result.size() - 1;
        while (left < right) {
            int temp = result.get(left);
            result.set(left,result.get(right));
            result.set(right,temp);
            left++;
            right--;
        }
        return result;
    }
}
