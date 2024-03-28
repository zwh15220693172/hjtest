package hjtest.leecode.二叉树;


import hjtest.data.Node;
import java.util.*;

public class LeeCode116 {
    public Node connect(Node root) {
        if (Objects.isNull(root)) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Node> line = new ArrayList<>();
            while (size > 0) {
                Node curNode = queue.poll();
                line.add(curNode);
                if (Objects.nonNull(curNode.left)) {
                    queue.add(curNode.left);
                }
                if (Objects.nonNull(curNode.right)) {
                    queue.add(curNode.right);
                }
                size--;
            }
            Node pre = null;
            for (Node node : line) {
                if (Objects.isNull(pre)) {
                    pre = node;
                    continue;
                }
                pre.next = node;
                pre = node;
            }
        }
        return root;
    }
}
