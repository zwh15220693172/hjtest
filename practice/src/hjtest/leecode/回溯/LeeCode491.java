package hjtest.leecode.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeeCode491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        LinkedList<Integer> path = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        getResult(0,nums,path,result);
        return result;
    }

    private void getResult(int start, int[] nums,
                           LinkedList<Integer> path, List<List<Integer>> result) {
        boolean[] used = new boolean[201];
        for (int i = start; i < nums.length; i++) {
            if (used[nums[i]+100]) {
                continue;
            }
            if (path.isEmpty() || path.getLast() <= nums[i]) {
                used[nums[i]+100] = true;
                path.addLast(nums[i]);
                if (path.size() >= 2) {
                    result.add(new ArrayList<>(path));
                }
                getResult(i+1,nums,path,result);
                path.removeLast();
            }
        }
    }
}
