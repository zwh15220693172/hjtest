package hjtest.leecode.二叉树;

import hjtest.data.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class LeeCode112 {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        LinkedList<Integer> path = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        pathSum(root, path, result);
        return result.contains(targetSum);
    }

    private void pathSum(TreeNode node, LinkedList<Integer> path, List<Integer> result) {
        if (Objects.isNull(node)) {
            return;
        }
        path.addLast(node.val);
        if (Objects.isNull(node.left) && Objects.isNull(node.right)) {
            int sum = path.stream().mapToInt(Integer::intValue).sum();
            result.add(sum);
        }
        pathSum(node.left, path, result);
        pathSum(node.right, path, result);
        path.removeLast();
    }
}
