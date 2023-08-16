package hjtest.B复100分.hj81报数游戏;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextInt()) {
            int m = input.nextInt();
            if (m <= 1 || m >= 100) {
                System.out.println("ERROR!");
            } else {
                List<Integer> list = buildList();
                remove(1,m,list);
            }
        }
        input.close();
    }

    private static void remove(int count, int m, List<Integer> list) {
        if (list.size() < m) {
            String collect = list.stream().map(String::valueOf).collect(Collectors.joining(","));
            System.out.println(collect);
            return;
        }
        List<Integer> next = new ArrayList<>();
        for (int num : list) {
            if (count == m) {
                count = 1;
            } else {
                next.add(num);
                count++;
            }
        }
        remove(count, m, next);
    }

    private static List<Integer> buildList() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            list.add(i);
        }
        return list;
    }
}
