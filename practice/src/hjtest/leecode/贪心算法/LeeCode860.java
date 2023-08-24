package hjtest.leecode.贪心算法;

public class LeeCode860 {
    public boolean lemonadeChange(int[] bills) {
        if (bills[0] != 5) {
            return false;
        }
        int fiveCount = 0;
        int tenCount = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                fiveCount++;
            } else if (bills[i] == 10) {
                if (fiveCount == 0) {
                    return false;
                }
                fiveCount--;
                tenCount++;
            } else if (bills[i] == 20) {
                if (tenCount > 0 && fiveCount > 0) {
                    tenCount--;
                    fiveCount--;
                } else if (fiveCount >= 3) {
                    fiveCount-=3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
