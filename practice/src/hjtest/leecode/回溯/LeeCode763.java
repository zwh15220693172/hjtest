package hjtest.leecode.回溯;

import java.util.*;
import java.util.stream.Collectors;

public class LeeCode763 {
    public List<Integer> partitionLabels(String s) {
        char[] chars = s.toCharArray();
        Map<Character, LinkedList<Integer>> charIndexMap = buildCharIndexMap(chars);
        int[][] intervals = getIntervals(charIndexMap);
        Stack<int[]> cursor = new Stack<>();
        ArrayList<Integer> resultList = new ArrayList<>();
        for (int[] cur : intervals) {
            if (cursor.isEmpty()) {
                cursor.push(cur);
                continue;
            }
            int[] last = cursor.pop();
            int right = last[1];
            int left = cur[0];
            if (left <= right) {
                last[1] = Math.max(cur[1], right);
                cursor.push(last);
            } else {
                int result = last[1] - last[0] + 1;
                resultList.add(result);
                cursor.push(cur);
            }
        }
        if (!cursor.isEmpty()) {
            int[] last = cursor.pop();
            int result = last[1] - last[0] + 1;
            resultList.add(result);
        }
        return resultList;
    }

    private int[][] getIntervals(Map<Character, LinkedList<Integer>> charIndexMap) {
        List<LinkedList<Integer>> values = charIndexMap.values().stream().collect(Collectors.toList());
        int[][] intervals = new int[values.size()][2];
        int index = 0;
        for (LinkedList<Integer> indexList : values) {
            int left = indexList.getFirst();
            int right = indexList.getLast();
            intervals[index++] = new int[]{left, right};
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return b[1] - a[1];
                } else {
                    return a[0] - b[0];
                }
            }
        });
        return intervals;
    }

    private Map<Character, LinkedList<Integer>> buildCharIndexMap(char[] chars) {
        Map<Character, LinkedList<Integer>> charIndexMap = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            char cur = chars[i];
            if (!charIndexMap.containsKey(cur)) {
                charIndexMap.put(cur, new LinkedList<>());
            }
            LinkedList<Integer> indexList = charIndexMap.get(cur);
            indexList.addLast(i);
        }
        return charIndexMap;
    }
}
