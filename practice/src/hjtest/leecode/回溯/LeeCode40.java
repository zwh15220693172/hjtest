package hjtest.leecode.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeeCode40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        boolean[] used = new boolean[candidates.length];
        backtracking(0,candidates,used,0,target,path,result);
        return result;
    }

    private void backtracking(int index, int[] candidates, boolean[] used, int sum, int target,
                              LinkedList<Integer> path, List<List<Integer>> result) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i-1] && !used[i-1]) {
                continue;
            }
            if (candidates[i] > target || sum + candidates[i] > target) {
                break;
            }
            path.addLast(candidates[i]);
            used[i] = true;
            backtracking(i+1,candidates,used,sum+candidates[i],target,path,result);
            path.removeLast();
            used[i] = false;
        }
    }
}
