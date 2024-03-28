package hjtest.leecode.贪心算法;

public class LeeCode605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        int len = flowerbed.length;
        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }
            if (left(i, flowerbed) && right(i, len, flowerbed)) {
                flowerbed[i] = 1;
                count++;
            }
        }
        return count >= n;
    }

    private boolean right(int i, int len, int[] flowerbed) {
        if (i + 1 == len) {
            return true;
        }
        return flowerbed[i+1] == 0;
    }

    private boolean left(int i, int[] flowerbed) {
        if (i == 0) {
            return true;
        }
        return flowerbed[i-1] == 0;
    }
}
