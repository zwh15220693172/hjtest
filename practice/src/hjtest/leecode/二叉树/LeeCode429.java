package hjtest.leecode.二叉树;

import java.util.*;

public class LeeCode429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (Objects.isNull(root)) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> cursor = new ArrayList<>();
            int size = queue.size();
            while (size > 0) {
                Node curNode = queue.poll();
                cursor.add(curNode.val);
                List<Node> children = curNode.children;
                for (Node child : children) {
                    if (Objects.nonNull(child)) {
                        queue.add(child);
                    }
                }
                size--;
            }
            result.add(cursor);
        }
        return result;
    }

    private class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
