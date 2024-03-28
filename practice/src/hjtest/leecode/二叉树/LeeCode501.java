package hjtest.leecode.二叉树;

import hjtest.data.TreeNode;

import java.util.*;

public class LeeCode501 {
    public int[] findMode(TreeNode root) {
        Map<Integer,Integer> numCount = new HashMap<>();
        search(numCount, root);
        int max = numCount.values().stream().mapToInt(Integer::intValue).max().orElse(0);
        List<Integer> result = new ArrayList<>();
        Set<Integer> keys = numCount.keySet();
        for (int key : keys) {
            int count = numCount.get(key);
            if (count == max) {
                result.add(key);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private void search(Map<Integer, Integer> numCount, TreeNode node) {
        if (Objects.isNull(node)) {
            return;
        }
        int val = node.val;
        int count;
        count = numCount.getOrDefault(val, 1);
        count++;
        numCount.put(val,count);
        search(numCount,node.left);
        search(numCount, node.right);
    }
}
