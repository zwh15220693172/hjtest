package hjtest.leecode.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeeCode216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        backtracking(0,k,0,n,1,path,result);
        return result;
    }

    private void backtracking(int cur, int k, int sum, int n, int start,
                              LinkedList<Integer> path, List<List<Integer>> result) {
        if (cur == k) {
            if (sum == n) {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i = start; i <= 9; i++) {
            path.addLast(i);
            backtracking(cur+1,k,sum+i,n,i+1,path,result);
            path.removeLast();
        }
    }
}
