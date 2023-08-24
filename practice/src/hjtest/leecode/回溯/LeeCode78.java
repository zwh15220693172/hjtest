package hjtest.leecode.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeeCode78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        backtracking(0,nums,path,result);
        result.add(new ArrayList<>());
        return result;
    }

    private void backtracking(int index, int[] nums, LinkedList<Integer> path, List<List<Integer>> result) {
        for (int i = index; i < nums.length; i++) {
            path.addLast(nums[i]);
            result.add(new ArrayList<>(path));
            backtracking(i+1,nums,path,result);
            path.removeLast();
        }
    }
}
