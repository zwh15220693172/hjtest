package hjtest.B复200分.hj13区间交集;

import java.util.*;

/**
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextInt()) {
            int len = input.nextInt();
            int[][] ints = getInts(len,input);
            Arrays.sort(ints, new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    if (a[0] == b[0]) {
                        return a[1] - b[1];
                    }
                    return a[0] - b[0];
                }
            });
            LinkedList<int[]> queue = new LinkedList<>();
            for (int i = 0; i < len; i++) {
                int[] cur = ints[i];
                for (int j = i + 1; j < len; j++) {
                    int[] next = ints[j];
                    if (next[0] <= cur[1]) {
                        int left = next[0];
                        int right = Math.min(next[1],cur[1]);
                        queue.addLast(new int[]{left,right});
                    }
                }
            }
            if (queue.isEmpty()) {
                System.out.println("None");
            } else {
                queue.sort(new Comparator<int[]>() {
                    @Override
                    public int compare(int[] a, int[] b) {
                        if (a[0] == b[0]) {
                            return b[1] - a[1];
                        }
                        return a[0] - b[0];
                    }
                });
                Stack<int[]> cursor = new Stack<>();
                while (!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    if (cursor.isEmpty()) {
                        cursor.push(cur);
                    } else {
                        if (cursor.peek()[1] >= cur[0]) {
                            int[] last = cursor.pop();
                            int left = Math.min(cur[0],last[0]);
                            int right = Math.max(cur[1],last[1]);
                            cursor.push(new int[]{left,right});
                        } else {
                            cursor.push(cur);
                        }
                    }
                }
                cursor.forEach(array->System.out.println(array[0] + " " + array[1]));
            }
        }
        input.close();
    }

    private static int[][] getInts(int count, Scanner input) {
        int[][] ints = new int[count][];
        int index = 0;
        while (count > 0) {
            int x = input.nextInt();
            int y = input.nextInt();
            ints[index++] = new int[]{x,y};
            count--;
        }
        return ints;
    }
}
