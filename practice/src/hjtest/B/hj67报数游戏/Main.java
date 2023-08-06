package hjtest.B.hj67报数游戏;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int m = Integer.parseInt(input.nextLine());
            if (m <= 1 || m >= 100) {
                System.out.println("ERROR!");
            } else {
                List<Integer> list = buildList();
                removeList(list,m,1);
            }
        }
        input.close();
    }

    private static void removeList(List<Integer> list, int m, int count) {
        if (list.size() < m) {
            String collect = list.stream().map(String::valueOf).collect(Collectors.joining(","));
            System.out.println(collect);
            return;
        }
        List<Integer> next = new ArrayList<>();
        for (Integer cur : list) {
            if (count == m) {
                count = 1;
            } else {
                next.add(cur);
                count++;
            }
        }
        removeList(next,m,count);
    }

    private static List<Integer> buildList() {
        return IntStream.rangeClosed(1,100).boxed().collect(Collectors.toList());
    }
}
