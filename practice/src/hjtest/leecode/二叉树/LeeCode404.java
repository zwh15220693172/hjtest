package hjtest.leecode.二叉树;

import hjtest.data.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LeeCode404 {
    public int sumOfLeftLeaves(TreeNode root) {
        List<Integer> leftList = new ArrayList<>();
        findLeft(root,leftList);
        return leftList.stream().mapToInt(Integer::intValue).sum();
    }

    private void findLeft(TreeNode curNode, List<Integer> leftList) {
        if (Objects.isNull(curNode)) {
            return;
        }
        if (Objects.nonNull(curNode.left) && Objects.isNull(curNode.left.left) && Objects.isNull(curNode.left.right)) {
            leftList.add(curNode.left.val);
        }
        findLeft(curNode.left,leftList);
        findLeft(curNode.right,leftList);
    }
}
