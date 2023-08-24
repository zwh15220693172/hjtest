package hjtest.leecode.贪心算法;

import java.util.Arrays;

public class LeeCode135 {
    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        candy[0] = 1;
        for (int i = 1; i < candy.length; i++) {
            if (ratings[i] > ratings[i-1]) {
                candy[i] = candy[i-1]+1;
            } else {
                candy[i] = 1;
            }
        }
        for (int i = candy.length - 1; i > 0; i--) {
            if (ratings[i-1] > ratings[i]) {
                candy[i-1] = Math.max(candy[i-1],candy[i]+1);
            }
        }
        return Arrays.stream(candy).sum();
    }
}
