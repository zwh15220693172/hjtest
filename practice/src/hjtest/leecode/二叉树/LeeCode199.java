package hjtest.leecode.二叉树;

import hjtest.data.TreeNode;

import java.util.*;

public class LeeCode199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (Objects.isNull(root)) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> cursor = new LinkedList<>();
            while (size > 0) {
                TreeNode cur = queue.poll();
                cursor.addLast(cur.val);
                if (Objects.nonNull(cur.left)) {
                    queue.add(cur.left);
                }
                if (Objects.nonNull(cur.right)) {
                    queue.add(cur.right);
                }
                size--;
            }
            if (!cursor.isEmpty()) {
                result.add(cursor.getLast());
            }
        }
        return result;
    }
}
