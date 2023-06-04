package hjtest.A.hj1最大化控制资源成本;

import java.util.Arrays;
import java.util.Comparator;

public class LeeCode253 {
    public int minMeetingRooms(int[][] intervals) {
        sort(intervals);
        int max = 0;
        for (int i = 0; i < intervals.length; i++) {
            int[] cur = intervals[i];
            int curMax = 1;
            int right = cur[1];
            for (int j = i + 1; j < intervals.length; j++) {
                int[] next = intervals[j];
                int left = next[0];
                if (left < right) {
                    curMax++;
                }
            }
            max = Math.max(max, curMax);
        }
        return max;
    }

    private void sort(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] == b[1]) {
                    return a[0] - b[0];
                } else {
                    return a[1] - b[1];
                }
            }
        });
    }
}
