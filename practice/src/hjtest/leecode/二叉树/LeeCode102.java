package hjtest.leecode.二叉树;

import hjtest.data.TreeNode;
import java.util.*;

public class LeeCode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (Objects.isNull(root)) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> line = new ArrayList<>();
            while (size > 0) {
                TreeNode curNode = queue.poll();
                line.add(curNode.val);
                if (Objects.nonNull(curNode.left)) {
                    queue.add(curNode.left);
                }
                if (Objects.nonNull(curNode.right)) {
                    queue.add(curNode.right);
                }
                size--;
            }
            result.add(line);
        }
        return result;
    }
}
