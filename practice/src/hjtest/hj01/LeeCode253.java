package hjtest.hj01;

import java.util.Arrays;

public class LeeCode253 {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 1) {
            return 1;
        }
        sort(intervals);
        int max = 0;
        for (int i = 0; i < intervals.length; i++) {
            int[] cur = intervals[i];
            int right = cur[1];
            int curMax = 1;
            for (int j = i + 1; j < intervals.length; j++) {
                int[] next = intervals[j];
                int left = next[0];
                if (left < right) {
                    curMax++;
                }
            }
            max = Math.max(max,curMax);
        }
        return max;
    }

    private void sort(int[][] intervals) {
        Arrays.sort(intervals,(ints1, ints2)->{
            if (ints1[1] == ints2[1]) {
                return ints1[0] - ints2[0];
            } else {
                return ints1[1] - ints2[1];
            }
        });
    }
}
