package hjtest.A.hj22区间叠加问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class LeeCode1024 {
    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return b[1] - a[1];
                }
                return a[0] - b[0];
            }
        });
        int[][] ints = removeSame(clips);
        int[] minMax = getMinMax(ints);
        if (minMax[0] != 0 || minMax[1] < time) {
            return -1;
        }
        int[] start = ints[0];
        int end = start[1];
        return getResult(0,1,end,time,ints);
    }

    private int getResult(int index, int count, int end, int time, int[][] ints) {
        if (end >= time) {
            return count;
        }
        int nextIndex = -1;
        int max = end;
        for (int i = index + 1; i < ints.length; i++) {
            int[] next = ints[i];
            if (next[0] <= end && next[1] > max) {
                max = next[1];
                nextIndex = i;
            }
        }
        if (nextIndex == -1) {
            return -1;
        }
        return getResult(nextIndex,count+1,max,time,ints);
    }

    private int[] getMinMax(int[][] ints) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int[] cur : ints) {
            min = Math.min(cur[0],min);
            max = Math.max(cur[1],max);
        }
        return new int[]{min,max};
    }

    private int[][] removeSame(int[][] clips) {
        ArrayList<int[]> ints = new ArrayList<>();
        ints.add(clips[0]);
        int[] pre = clips[0];
        for (int i = 1; i < clips.length; i++) {
            int[] cur = clips[i];
            if (cur[0] == pre[0]) {
                continue;
            }
            ints.add(cur);
            pre = cur;
        }
        return ints.toArray(new int[0][]);
    }
}
