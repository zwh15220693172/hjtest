package hjtest.leecode.俄罗斯套娃;

import java.util.Arrays;
import java.util.Comparator;

public class LeeCode354 {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 1) {
            return 1;
        }
        sort(envelopes);
        int[] dp = buildDp(envelopes);
        int res = 0;
        for (int i = 1; i < dp.length; i++) {
            int[] cur = envelopes[i];
            for (int j = 0; j < i; j++) {
                int[] last = envelopes[j];
                if (cur[0] > last[0] && cur[1] > last[1]) {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            res = Math.max(dp[i],res);
        }
        return res;
    }

    private int[] buildDp(int[][] envelopes) {
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp,1);
        return dp;
    }

    private void sort(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
    }
}
