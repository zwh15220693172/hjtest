package hjtest.leecode.回溯;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeeCode77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        backtracking(0,k,1,n,path,result);
        return result;
    }

    private void backtracking(int cur, int k, int num, int n,
                              LinkedList<Integer> path, List<List<Integer>> result) {
        if (cur == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = num; i <= n; i++) {
            path.addLast(i);
            backtracking(cur+1,k,i+1,n,path,result);
            path.removeLast();
        }
    }
}
