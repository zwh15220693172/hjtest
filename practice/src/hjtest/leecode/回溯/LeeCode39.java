package hjtest.leecode.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeeCode39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        backtracking(0,candidates,0,target,path,result);
        return result;
    }

    private void backtracking(int index, int[] candidates, int sum, int target,
                              LinkedList<Integer> path, List<List<Integer>> result) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target || sum + candidates[i] > target) {
                break;
            }
            path.addLast(candidates[i]);
            backtracking(i,candidates,sum+candidates[i],target,path,result);
            path.removeLast();
        }
    }
}
