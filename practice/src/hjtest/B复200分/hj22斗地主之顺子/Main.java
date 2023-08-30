package hjtest.B复200分.hj22斗地主之顺子;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 只能通过100%
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String[] source = input.nextLine().split(" ");
            int[] cardAndCount = cardAndCount(source);
            int index = 3;
            List<String> result = new ArrayList<>();
            while (index < cardAndCount.length) {
                if (cardAndCount[index] == 0) {
                    index++;
                } else {
                    LinkedList<Integer> path = new LinkedList<>();
                    backtracking(index,cardAndCount,path);
                    if (path.size() >= 5) {
                        String collect = path.stream().map(Main::numMapToStr)
                                .collect(Collectors.joining(" "));
                        result.add(collect);
                    }
                }
            }
            if (result.isEmpty()) {
                System.out.println("No");
            } else {
                result.forEach(System.out::println);
            }
        }
        input.close();
    }

    private static String numMapToStr(int num) {
        if (num == 1) {
            return "A";
        } else if (num == 11) {
            return "J";
        } else if (num == 12) {
            return "Q";
        } else if (num == 13) {
            return "K";
        } else {
            return String.valueOf(num);
        }
    }

    private static void backtracking(int cur, int[] cardAndCount, LinkedList<Integer> path) {
        if (cur >= cardAndCount.length || cardAndCount[cur] == 0) {
            return;
        }
        cardAndCount[cur]--;
        path.addLast(cur);
        if (cur == cardAndCount.length - 1 && cardAndCount[1] > 0) {
            path.addLast(1);
            cardAndCount[1]--;
            return;
        }
        backtracking(cur+1,cardAndCount,path);
    }

    private static int[] cardAndCount(String[] source) {
        int[] cardAndCount = new int[14];
        for (String cur : source) {
            if ("A".equals(cur)) {
                cardAndCount[1]++;
            } else if ("J".equals(cur)) {
                cardAndCount[11]++;
            } else if ("Q".equals(cur)) {
                cardAndCount[12]++;
            } else if ("K".equals(cur)) {
                cardAndCount[13]++;
            } else {
                int index = Integer.parseInt(cur);
                cardAndCount[index]++;
            }
        }
        return cardAndCount;
    }
}
