package hjtest.leecode.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeeCode47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        getResult(0,nums,used,path,result);
        return result;
    }

    private void getResult(int cur, int[] nums, boolean[] used, LinkedList<Integer> path, List<List<Integer>> result) {
        if (cur == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            getResult(cur+1,nums,used,path,result);
            used[i] = false;
            path.removeLast();
        }
    }
}
