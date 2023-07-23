package hjtest.B复.hj13跳格子游戏;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int len = Integer.parseInt(input.nextLine());
            HashMap<Integer,List<Integer>> startEndMap = startEndMap(input);
            List<Integer> listStart = listStart(len, startEndMap);
            if (listStart.isEmpty()) {
                System.out.println("no");
            } else {
                boolean[] visit = new boolean[len];
                for (int start : listStart) {
                    calVisit(start, visit, startEndMap);
                }
                if (allVisit(visit)) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            }
        }
        input.close();
    }

    private static void calVisit(int start, boolean[] visit, HashMap<Integer, List<Integer>> startEndMap) {
        visit[start] = true;
        if (!startEndMap.containsKey(start)) {
            return;
        }
        List<Integer> nextList = startEndMap.get(start);
        for (int next : nextList) {
            calVisit(next, visit, startEndMap);
        }
    }

    private static boolean allVisit(boolean[] visit) {
        for (int i = 0; i < visit.length; i++) {
            if (!visit[i]) {
                return false;
            }
        }
        return true;
    }

    private static List<Integer> listStart(int len, HashMap<Integer, List<Integer>> startEndMap) {
        Collection<List<Integer>> values = startEndMap.values();
        HashSet<Integer> ends = new HashSet<>();
        for (List<Integer> value : values) {
            ends.addAll(value);
        }
        List<Integer> listStart = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (!ends.contains(i)) {
                listStart.add(i);
            }
        }
        return listStart;
    }

    private static HashMap<Integer, List<Integer>> startEndMap(Scanner input) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        while (true) {
            String inputStr = input.nextLine();
            if (inputStr.isEmpty()) {
                break;
            }
            String[] splits = inputStr.split(" ");
            int start = Integer.parseInt(splits[0]);
            int end = Integer.parseInt(splits[1]);
            List<Integer> ends;
            if (map.containsKey(start)) {
                ends = map.get(start);
            } else {
                ends = new ArrayList<>();
                map.put(start, ends);
            }
            ends.add(end);
        }
        return map;
    }
}
