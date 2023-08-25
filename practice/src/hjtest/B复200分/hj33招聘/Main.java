package hjtest.B复200分.hj33招聘;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int max = input.nextInt();
        int size = input.nextInt();
        int[][] ints = new int[size][];
        reset(size,ints,input);
        Arrays.sort(ints, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] == b[1]) {
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            }
        });
        List<LinkedList<Integer>> elements = buildElements(size);
        for (int[] anInt : ints) {
            int start = anInt[0];
            int end = anInt[1];
            for (LinkedList<Integer> element : elements) {
                if (element.isEmpty() || (element.size() < max && element.getLast() <= start)) {
                    element.addLast(end);
                    break;
                }
            }
        }
        long count = elements.stream().filter((list) -> list.size() > 0).count();
        System.out.println(count);
    }

    private static List<LinkedList<Integer>> buildElements(int size) {
        List<LinkedList<Integer>> elements = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            elements.add(new LinkedList<>());
        }
        return elements;
    }

    private static void reset(int size, int[][] ints, Scanner input) {
        int index = 0;
        while (size > 0) {
            ints[index++] = new int[]{input.nextInt(), input.nextInt()};
            size--;
        }
    }
}
