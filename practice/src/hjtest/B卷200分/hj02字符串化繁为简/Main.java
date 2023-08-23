package hjtest.B卷200分.hj02字符串化繁为简;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            char[] chars = input.nextLine().toCharArray();
            boolean addList = false;
            List<Character> source = new ArrayList<>();
            List<List<Character>> totalList = new ArrayList<>();
            List<Character> list = new ArrayList<>();
            for (char cur : chars) {
                if (cur == '(') {
                    addList = true;
                    list.clear();
                    continue;
                }
                if (cur == ')') {
                    addList = false;
                    if (!list.isEmpty()) {
                        totalList.add(new ArrayList<>(list));
                    }
                    continue;
                }
                if (addList) {
                    list.add(cur);
                } else {
                    source.add(cur);
                }
            }
            List<List<Character>> merge = merge(totalList);
            StringBuilder res = new StringBuilder();
            for (Character cur : source) {
                for (List<Character> characters : merge) {
                    if (characters.contains(cur)) {
                        cur = characters.get(0);
                        break;
                    }
                }
                res.append(cur);
            }
            if (res.length() == 0) {
                System.out.println("0");
            } else {
                System.out.println(res);
            }
        }
        input.close();
    }

    private static List<List<Character>> merge(List<List<Character>> totalList) {
        outer:
        while (true) {
            for (int i = 0; i < totalList.size(); i++) {
                for (int j = i + 1; j < totalList.size(); j++) {
                    if (contain(totalList.get(i),totalList.get(j))) {
                        totalList.get(i).addAll(totalList.get(j));
                        totalList.remove(j);
                        continue outer;
                    }
                }
            }
            break;
        }
        List<List<Character>> merge = totalList.stream().filter(list -> list.size() > 1)
                .collect(Collectors.toList());
        merge.forEach((list)->list.sort(new Comparator<Character>() {
            @Override
            public int compare(Character a, Character b) {
                return a - b;
            }
        }));
        return merge;
    }

    private static boolean contain(List<Character> char1, List<Character> char2) {
        for (char cur : char1) {
            for (char next : char2) {
                if ((Character.toLowerCase(cur) == next)
                        || (Character.toUpperCase(cur) == next)) {
                    return true;
                }
            }
        }
        return false;
    }
}
