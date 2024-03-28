package hjtest.leecode.二叉树;

import hjtest.data.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class LeeCode637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        LinkedList<TreeNode> cursor = new LinkedList<>();
        cursor.addLast(root);
        while (!cursor.isEmpty()) {
            List<Integer> line = new ArrayList<>();
            int size = cursor.size();
            int count = size;
            while (count > 0) {
                TreeNode cur = cursor.pop();
                line.add(cur.val);
                if (Objects.nonNull(cur.left)) {
                    cursor.addLast(cur.left);
                }
                if (Objects.nonNull(cur.right)) {
                    cursor.addLast(cur.right);
                }
                count--;
            }
            long sum = getSum(line);
            double result = sum * 1.0 / size;
            list.add(result);
        }
        return list;
    }

    private long getSum(List<Integer> line) {
        long sum = 0;
        for (Integer cur : line) {
            sum += cur;
        }
        return sum;
    }
}
