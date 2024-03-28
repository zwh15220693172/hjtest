package hjtest.leecode.二叉树;

import hjtest.data.TreeNode;

import java.util.LinkedList;
import java.util.Objects;

public class LeeCode513 {
    public int findBottomLeftValue(TreeNode root) {
        LinkedList<TreeNode> cursor = new LinkedList<>();
        cursor.addLast(root);
        int result = -1;
        while (!cursor.isEmpty()) {
            result = cursor.peek().val;
            int size = cursor.size();
            while (size > 0) {
                TreeNode cur = cursor.pop();
                if (Objects.nonNull(cur.left)) {
                    cursor.addLast(cur.left);
                }
                if (Objects.nonNull(cur.right)) {
                    cursor.addLast(cur.right);
                }
                size--;
            }
        }
        return result;
    }
}
