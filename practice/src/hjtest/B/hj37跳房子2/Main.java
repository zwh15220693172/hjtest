package hjtest.B.hj37跳房子2;

import com.sun.java.swing.plaf.windows.WindowsDesktopIconUI;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final LinkedList<Node> path = new LinkedList<>();
    private static final List<List<Node>> result = new ArrayList<>();

    private static final int MAX_STEP = 3;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            path.clear();
            result.clear();
            int target = Integer.parseInt(input.nextLine());
            int[] ints = getInts(input.nextLine());
            Node[] nodes = getNodes(ints);
            getResult(0,0,target,nodes);
            Optional<List<Node>> min = result.stream().min(new Comparator<List<Node>>() {
                @Override
                public int compare(List<Node> a, List<Node> b) {
                    int sumA = a.stream().mapToInt(Node::getIndex).sum();
                    int sumB = b.stream().mapToInt(Node::getIndex).sum();
                    return sumA - sumB;
                }
            });
            if (min.isPresent()) {
                List<Node> result = min.get();
                int[] ints1 = result.stream().mapToInt(Node::getNum).toArray();
                System.out.println(Arrays.toString(ints1));
            }
        }
        input.close();
    }

    private static void getResult(int step, int index, int target, Node[] nodes) {
        if (step == MAX_STEP) {
            if (path.stream().mapToInt(Node::getNum).sum() == target)  {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = index; i < nodes.length; i++) {
            path.addLast(nodes[i]);
            getResult(step+1,index+1,target,nodes);
            path.removeLast();
        }
    }

    private static Node[] getNodes(int[] ints) {
        Node[] nodes = new Node[ints.length];
        for (int i = 0; i < ints.length; i++) {
            nodes[i] = new Node(ints[i],i);
        }
        return nodes;
    }

    private static int[] getInts(String nextLine) {
        String substring = nextLine.substring(1, nextLine.length() - 1);
        return Arrays.stream(substring.split(","))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static class Node {
        private final int num;
        private final int index;

        public Node(int num, int index) {
            this.num = num;
            this.index = index;
        }

        public int getNum() {
            return num;
        }

        public int getIndex() {
            return index;
        }
    }
}
