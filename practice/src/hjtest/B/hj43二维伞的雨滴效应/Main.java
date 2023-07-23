package hjtest.B.hj43二维伞的雨滴效应;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] preOrder = getPreOrder(input.nextLine());
            int[] inOrder = getInOrder(preOrder);
            Node root = getNode(preOrder, inOrder);
            int[] myPre = getMyPre(root);
            if (Arrays.equals(preOrder, myPre)) {
                System.out.println(1 + " " + getLeft(root) + " " + preOrder[preOrder.length-1]);
            } else {
                System.out.println(0 + " " + 0 + " " + 0);
            }
        }
        input.close();
    }

    private static int getLeft(Node curNode) {
        if (Objects.isNull(curNode)) {
            return 0;
        }
        if (Objects.isNull(curNode.left) && Objects.isNull(curNode.right)) {
            return curNode.val;
        }
        Node next;
        if (Objects.nonNull(curNode.left)) {
            next = curNode.left;
        } else {
            next = curNode.right;
        }
        return getLeft(next);
    }

    private static int[] getMyPre(Node root) {
        Stack<Node> cursor = new Stack<>();
        cursor.add(root);
        List<Integer> list = new ArrayList<>();
        while (!cursor.isEmpty()) {
            Node cur = cursor.pop();
            list.add(cur.val);
            if (cur.right != null) {
                cursor.add(cur.right);
            }
            if (cur.left != null) {
                cursor.add(cur.left);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private static Node getNode(int[] preOrder, int[] inOrder) {
        if (preOrder.length == 0 || inOrder.length == 0) {
            return null;
        }
        int rootVal = preOrder[0];
        int rootIndex = findRootIndex(rootVal, inOrder);
        Node cur = new Node(rootVal);
        int[] inLeft = getInts(0,rootIndex,inOrder);
        int[] inRight = getInts(rootIndex+1, inOrder.length, inOrder);
        int[] preLeft = getInts(1,rootIndex+1,preOrder);
        int[] preRight = getInts(rootIndex+1,preOrder.length,preOrder);
        cur.left = getNode(preLeft, inLeft);
        cur.right = getNode(preRight, inRight);
        return cur;
    }

    private static int[] getInts(int start, int end, int[] base) {
        int[] array = new int[end-start];
        int index = 0;
        for (int i = start; i < end; i++) {
            array[index++] = base[i];
        }
        return array;
    }

    private static int findRootIndex(int rootVal, int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == rootVal) {
                return i;
            }
        }
        return -1;
    }

    private static int[] getInOrder(int[] preOrder) {
        int[] inOrder = new int[preOrder.length];
        System.arraycopy(preOrder,0,inOrder,0,preOrder.length);
        Arrays.sort(inOrder);
        return inOrder;
    }

    private static int[] getPreOrder(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static class Node {
        private int val;
        private Node left;
        private Node right;

        public Node(int val) {
            this.val = val;
        }
    }
}
