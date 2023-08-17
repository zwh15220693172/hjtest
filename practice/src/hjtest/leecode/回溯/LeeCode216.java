package hjtest.leecode.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeeCode216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        getResult(1,0,k,0,n,path,result);
        return result;
    }

    private void getResult(int start,int cur, int k, int sum, int target, LinkedList<Integer> path, List<List<Integer>> result) {
        if (cur == k) {
            if (sum == target) {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            path.addLast(i);
            getResult(i+1,cur+1,k,sum+i,target,path,result);
            path.removeLast();
        }
    }
}
