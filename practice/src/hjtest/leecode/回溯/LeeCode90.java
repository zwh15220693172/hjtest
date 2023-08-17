package hjtest.leecode.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeeCode90 {
    public static void main(String[] args) {
        LeeCode90 leeCode90 = new LeeCode90();
        int[] nums = {1,2,2};
        leeCode90.subsetsWithDup(nums);
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        getResult(0,nums,used,path,result);
        result.add(new ArrayList<>());
        return result;
    }

    private void getResult(int start, int[] nums, boolean[] used, LinkedList<Integer> path, List<List<Integer>> result) {
        for (int i = start; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            result.add(new ArrayList<>(path));
            getResult(i+1,nums,used,path,result);
            path.removeLast();
            used[i] = false;
        }
    }
}
