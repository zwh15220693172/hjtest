package hjtest.B.hj3最佳植树距离;

import java.util.Arrays;

public class LeeCode1552 {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int min = getMin(position);
        int max = getMax(position);
        int target = 0;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (fit(mid, m, position)) {
                target = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return target;
    }

    private boolean fit(int mid, int m, int[] position) {
        int pre = position[0];
        int count = 1;
        for (int i = 1; i < position.length; i++) {
            if (position[i] - pre >= mid) {
                count++;
                pre = position[i];
                if (count >= m) {
                    return true;
                }
            }
        }
        return false;
    }

    private int getMax(int[] position) {
        return position[position.length-1] - position[0];
    }

    private int getMin(int[] position) {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < position.length; i++) {
            min = Math.min(position[i]-position[i-1],min);
        }
        return min;
    }
}
