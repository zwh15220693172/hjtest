package hjtest.leecode.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeeCode491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        backtracking(0,nums,path,result);
        return result;
    }

    private void backtracking(int index, int[] nums, LinkedList<Integer> path, List<List<Integer>> result) {
        boolean[] used = new boolean[201];
        for (int i = index; i < nums.length; i++) {
            if (used[nums[i]+100]) {
                continue;
            }
            if (path.isEmpty() || nums[i] >= path.getLast()) {
                path.addLast(nums[i]);
                used[nums[i]+100] = true;
                if (path.size() >= 2) {
                    result.add(new ArrayList<>(path));
                }
                backtracking(i+1,nums,path,result);
                path.removeLast();
            }
        }
    }
}
