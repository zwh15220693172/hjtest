package hjtest.B复200分.hj15最长的顺子;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String[] source01 = input.nextLine().split("-");
            String[] source02 = input.nextLine().split("-");
            boolean[] used = getUsed(source01,source02);
            List<Integer> result = new ArrayList<>();
            LinkedList<Integer> path = new LinkedList<>();
            for (int i = 3; i < used.length; i++) {
                if (!used[i]) {
                    path.addLast(i);
                    if (i == 13 && !used[1]) {
                        path.addLast(1);
                    }
                } else {
                    path.clear();
                }
                if (path.size() >= result.size()) {
                    result.clear();
                    result.addAll(path);
                }
            }
            if (result.size() >= 5) {
                String collect = result.stream().map(Main::mapToCard)
                        .collect(Collectors.joining("-"));
                System.out.println(collect);
            } else {
                System.out.println("NO-CHAIN");
            }
        }
    }

    private static String mapToCard(int num) {
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

    private static boolean[] getUsed(String[] source01, String[] source02) {
        boolean[] used = new boolean[14];
        HashMap<String,Integer> map = new HashMap<>();
        for (String cur : source01) {
            map.put(cur,map.getOrDefault(cur,0)+1);
        }
        for (String cur : source02) {
            map.put(cur,map.getOrDefault(cur,0)+1);
        }
        Set<String> keys = map.keySet();
        for (String key : keys) {
            int count = map.get(key);
            if (count == 4) {
                setUsed(key,used);
            }
        }
        return used;
    }

    private static void setUsed(String key, boolean[] used) {
        if ("A".equals(key)) {
            used[1] = true;
        } else if ("J".equals(key)) {
            used[11] = true;
        } else if ("Q".equals(key)) {
            used[12] = true;
        } else if ("K".equals(key)) {
            used[13] = true;
        } else {
            int index = Integer.parseInt(key);
            used[index] = true;
        }
    }
}
