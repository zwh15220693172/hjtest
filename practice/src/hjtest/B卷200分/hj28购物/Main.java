package hjtest.B卷200分.hj28购物;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextInt()) {
            int len = input.nextInt();
            int count = input.nextInt();
            int[] ints = getInts(len,input);
            PriorityQueue<Combine> queue = new PriorityQueue<>(new Comparator<Combine>() {
                @Override
                public int compare(Combine a, Combine b) {
                    return a.sum+ints[a.index] - (b.sum+ints[b.index]);
                }
            });
            queue.offer(new Combine(0,0));
            while (count > 0) {
                Combine cur = queue.poll();
                System.out.println(cur.sum+ints[cur.index]);
                if (cur.index + 1 < len) {
                    queue.offer(new Combine(cur.sum+ints[cur.index], cur.index+1));
                    cur.index++;
                    queue.offer(cur);
                }
                count--;
            }
        }
        input.close();
    }

    private static int[] getInts(int len, Scanner input) {
        int[] ints = new int[len];
        int index = 0;
        while (index < len) {
            ints[index++] = input.nextInt();
        }
        Arrays.sort(ints);
        return ints;
    }

    static class Combine{
        private int sum;
        private int index;

        public Combine(int sum, int index) {
            this.sum = sum;
            this.index = index;
        }
    }
}
