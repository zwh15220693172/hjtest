package hjtest.leecode.二叉树;

import hjtest.data.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class LeeCode515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (Objects.isNull(root)) {
            return result;
        }
        LinkedList<TreeNode> cursor = new LinkedList<>();
        cursor.add(root);
        while (!cursor.isEmpty()) {
            int size = cursor.size();
            int max = Integer.MIN_VALUE;
            while (size > 0) {
                TreeNode cur = cursor.pop();
                max = Math.max(cur.val, max);
                if (Objects.nonNull(cur.left)) {
                    cursor.addLast(cur.left);
                }
                if (Objects.nonNull(cur.right)) {
                    cursor.addLast(cur.right);
                }
                size--;
            }
            result.add(max);
        }
        return result;
    }
}
