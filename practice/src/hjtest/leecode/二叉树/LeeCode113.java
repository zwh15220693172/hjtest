package hjtest.leecode.二叉树;

import hjtest.data.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class LeeCode113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        LinkedList<Integer> path = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        pathSum(root, targetSum, path, result);
        return result;
    }

    private void pathSum(TreeNode node, int targetSum, LinkedList<Integer> path, List<List<Integer>> result) {
        if (Objects.isNull(node)) {
            return;
        }
        path.addLast(node.val);
        if (Objects.isNull(node.left) && Objects.isNull(node.right)) {
            int sum = path.stream().mapToInt(Integer::intValue).sum();
            if (sum == targetSum) {
                result.add(new ArrayList<>(path));
            }
        }
        pathSum(node.left, targetSum, path, result);
        pathSum(node.right, targetSum, path, result);
        path.removeLast();
    }
}
