package hjtest.leecode.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeeCode46 {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        backtracking(0,nums.length,nums,used,path,result);
        return result;
    }

    private void backtracking(int cur, int len,int[] nums, boolean[] used,
                              LinkedList<Integer> path, List<List<Integer>> result) {
        if (cur == len) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            backtracking(cur+1,len,nums,used,path,result);
            used[i] = false;
            path.removeLast();
        }
    }
}
