package hjtest.leecode.贪心算法;

public class LeeCode376 {
    public int wiggleMaxLength(int[] nums) {
        int result = 1;
        int preDiff = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int curDiff = nums[i+1] - nums[i];
            if ((preDiff >= 0 && curDiff < 0) || (preDiff <=0 && curDiff > 0)) {
                result++;
                preDiff = curDiff;
            }
        }
        return result;
    }
}
