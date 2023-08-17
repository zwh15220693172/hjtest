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
        getResult(0,0,target,used,candidates,path,result);
        return result;
    }

    private void getResult(int start, int sum, int target, boolean[] used, int[] candidates,
                           LinkedList<Integer> path, List<List<Integer>> result) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && candidates[i] == candidates[i-1] && !used[i-1]) {
                continue;
            }
            if (candidates[i] > target || sum + candidates[i] > target) {
                break;
            }
            path.addLast(candidates[i]);
            used[i] = true;
            getResult(i+1,sum+candidates[i],target,used,candidates,path,result);
            path.removeLast();
            used[i] = false;
        }
    }
}
