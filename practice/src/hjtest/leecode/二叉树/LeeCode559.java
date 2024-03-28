package hjtest.leecode.二叉树;

import hjtest.data.Node;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LeeCode559 {
    public int maxDepth(Node root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        if (Objects.isNull(root.children)) {
            return 1;
        }
        List<Node> nodes = root.children;
        int max = 0;
        for (Node node : nodes) {
            int cur = maxDepth(node);
            max = Math.max(cur, max);
        }
        return max + 1;
    }
}
