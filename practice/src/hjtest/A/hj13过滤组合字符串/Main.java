package hjtest.A.hj13过滤组合字符串;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final String[][] chars = {
            {"a","b","c"},
            {"d","e","f"},
            {"g","h","i"},
            {"j","k","l"},
            {"m","n","o"},
            {"p","q","r"},
            {"s","t"},
            {"u","v"},
            {"w","x"},
            {"y","z"},
    };

    private static final LinkedList<String> path = new LinkedList<>();
    private static final List<String> result = new ArrayList<>();
    private static String remove;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            path.clear();
            result.clear();
            int[] ints = getInts(input.nextLine());
            remove = input.nextLine();
            backtracking(0, ints);
            String collect = String.join(" ", result);
            System.out.println(collect);
        }
        input.close();
    }

    private static void backtracking(int index, int[] ints) {
        if (index == ints.length) {
            String cur = String.join("", path);
            if (!cur.equals(remove) && !cur.isEmpty()) {
                result.add(cur);
            }
            return;
        }
        int charIndex = ints[index];
        String[] chars = Main.chars[charIndex];
        for (String aChar : chars) {
            path.addLast(aChar);
            backtracking(index+1, ints);
            path.removeLast();
        }
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(""))
                .mapToInt(Integer::parseInt).toArray();
    }
}
