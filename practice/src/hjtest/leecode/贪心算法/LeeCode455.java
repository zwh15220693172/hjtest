package hjtest.leecode.贪心算法;

import java.util.Arrays;

public class LeeCode455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gLeft = 0;
        int sLeft = 0;
        int count = 0;
        while (gLeft < g.length && sLeft < s.length) {
            if (g[gLeft] <= s[sLeft]) {
                gLeft++;
                count++;
            }
            sLeft++;
        }
        return count;
    }
}
