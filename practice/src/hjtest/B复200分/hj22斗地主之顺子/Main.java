package hjtest.B复200分.hj22斗地主之顺子;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 只能通过80%
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            boolean[] used = buildUsed(input.nextLine());
            List<String> result = new ArrayList<>();
            for (int i = 3; i < used.length; i++) {
                List<Integer> cards = new ArrayList<>();
                int end = -1;
                if (used[i]) {
                    for (int j = i; j < used.length; j++) {
                        if (used[j]) {
                            cards.add(j);
                            end = j;
                        } else {
                            break;
                        }
                    }
                }
                if (cards.size() >= 4 && cards.contains(13) && used[1]) {
                    String collect = cards.stream().map(Main::mapperToCard)
                            .collect(Collectors.joining(" ")) + " " + "A";
                    result.add(collect);
                    i = end + 1;
                } else if (cards.size() >= 5) {
                    String collect = cards.stream().map(Main::mapperToCard)
                            .collect(Collectors.joining(" "));
                    result.add(collect);
                    i = end + 1;
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

    private static String mapperToCard(int num) {
        if (num == 1) {
            return "A";
        } else if (num == 11) {
            return "J";
        } else if (num == 12) {
            return "Q";
        } else if (num == 13) {
            return "K";
        }
        return String.valueOf(num);
    }

    private static boolean[] buildUsed(String nextLine) {
        boolean[] used = new boolean[14];
        String[] strings = nextLine.split(" ");
        for (String string : strings) {
            if ("A".equals(string)) {
                used[1] = true;
            } else if ("J".equals(string)) {
                used[11] = true;
            } else if ("Q".equals(string)) {
                used[12] = true;
            } else if ("K".equals(string)) {
                used[13] = true;
            } else {
                int index = Integer.parseInt(string);
                used[index] = true;
            }
        }
        return used;
    }
}
