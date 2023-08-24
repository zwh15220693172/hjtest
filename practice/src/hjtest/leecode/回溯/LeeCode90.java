package hjtest.leecode.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeeCode90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        boolean[] used = new boolean[nums.length];
        backtracking(0,nums,used,path,result);
        result.add(new ArrayList<>());
        return result;
    }

    private void backtracking(int index, int[] nums, boolean[] used,
                              LinkedList<Integer> path, List<List<Integer>> result) {
        for (int i = index; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            result.add(new ArrayList<>(path));
            backtracking(i+1,nums,used,path,result);
            used[i] = false;
            path.removeLast();
        }
    }
}
