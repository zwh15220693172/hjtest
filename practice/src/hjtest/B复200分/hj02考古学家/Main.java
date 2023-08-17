package hjtest.B复200分.hj02考古学家;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    private static final LinkedList<String> path = new LinkedList<>();
    private static final List<String> result = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            path.clear();
            result.clear();
            int len = Integer.parseInt(input.nextLine());
            String[] stones = input.nextLine().split(" ");
            Arrays.sort(stones);
            boolean[] used = new boolean[len];
            getResult(0,len,stones,used);
            result.stream().sorted().forEach(System.out::println);
        }
        input.close();
    }

    private static void getResult(int index, int len, String[] stones, boolean[] used) {
        if (index == len) {
            String cur = String.join("", path);
            result.add(cur);
            return;
        }
        for (int i = 0; i < stones.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && stones[i].equals(stones[i-1]) && !used[i-1]) {
                continue;
            }
            path.addLast(stones[i]);
            used[i] = true;
            getResult(index+1,len,stones,used);
            used[i] = false;
            path.removeLast();
        }
    }
}
