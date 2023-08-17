package hjtest.leecode.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LeeCode39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        Arrays.sort(candidates);
        getResult(0,0,target,candidates,path,result);
        return result;
    }

    private void getResult(int start, int sum, int target, int[] candidates, LinkedList<Integer> path, List<List<Integer>> result) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target || sum + candidates[i] > target) {
                break;
            }
            path.addLast(candidates[i]);
            getResult(i,sum+candidates[i],target,candidates,path,result);
            path.removeLast();
        }
    }
}
