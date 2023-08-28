package hjtest.leecode.俄罗斯套娃;

import java.util.Arrays;
import java.util.Comparator;

public class LeeCode354 {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int res = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            res = Math.max(dp[i],res);
        }
        return res;
    }
}
