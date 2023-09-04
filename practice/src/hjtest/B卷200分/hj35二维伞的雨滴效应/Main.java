package hjtest.B卷200分.hj35二维伞的雨滴效应;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] preInts = getInts(input.nextLine());
        int[] midInts = getMidInts(preInts);
        TreeNode root = getRoot(preInts,midInts);
        int[] truePreInts = getTruePreInts(root);
        if (Arrays.equals(preInts,truePreInts)) {
            List<Integer> cursor = new ArrayList<>();
            getLeft(root, cursor);
            int left = cursor.get(0);
            cursor.clear();
            getRight(root,cursor);
            int right = cursor.get(0);
            System.out.println(1 + " " + left + " " + right);
        } else {
            System.out.println(0 + " " + 0 + " " + 0);
        }
    }

    private static void getRight(TreeNode cur, List<Integer> cursor) {
        if (cur == null) {
            return;
        }
        if (cur.left == null && cur.right == null) {
            cursor.add(cur.val);
            return;
        }
        if (cur.right != null) {
            getRight(cur.right,cursor);
        } else {
            getRight(cur.left,cursor);
        }
    }

    private static void getLeft(TreeNode cur, List<Integer> cursor) {
        if (cur == null) {
            return;
        }
        if (cur.left == null && cur.right == null) {
            cursor.add(cur.val);
            return;
        }
        if (cur.left != null) {
            getLeft(cur.left,cursor);
        } else {
            getLeft(cur.right,cursor);
        }
    }

    private static int[] getTruePreInts(TreeNode root) {
        List<Integer> path = new ArrayList<>();
        backtracking(root,path);
        return path.stream().mapToInt(Integer::intValue).toArray();
    }

    private static void backtracking(TreeNode cur, List<Integer> path) {
        if (cur == null) {
            return;
        }
        path.add(cur.val);
        backtracking(cur.left,path);
        backtracking(cur.right,path);
    }

    private static TreeNode getRoot(int[] preInts, int[] midInts) {
        if (preInts.length == 0 || midInts.length == 0) {
            return null;
        }
        int rootVal = preInts[0];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = findRootIndex(rootVal, midInts);
        if (rootIndex == -1) {
            return null;
        }
        int[] leftMid = buildInts(0,rootIndex,midInts);
        int[] rightMid = buildInts(rootIndex+1, midInts.length, midInts);
        int[] leftPre = buildInts(1,1+rootIndex,preInts);
        int[] rightPre = buildInts(1+rootIndex, preInts.length, preInts);
        root.left = getRoot(leftPre,leftMid);
        root.right = getRoot(rightPre,rightMid);
        return root;
    }

    private static int[] buildInts(int start, int end, int[] midInts) {
        int[] ints = new int[end-start];
        int index = 0;
        for (int i = start; i < end; i++) {
            ints[index++] = midInts[i];
        }
        return ints;
    }

    private static int findRootIndex(int rootVal, int[] midInts) {
        for (int i = 0; i < midInts.length; i++) {
            if (midInts[i] == rootVal) {
                return i;
            }
        }
        return -1;
    }

    private static int[] getMidInts(int[] preInts) {
        int[] cur = new int[preInts.length];
        System.arraycopy(preInts,0,cur,0,preInts.length);
        Arrays.sort(cur);
        return cur;
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
