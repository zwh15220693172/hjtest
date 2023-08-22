package hjtest.B复200分.hj20发广播;

public class LeeCode547 {
    public int findCircleNum(int[][] isConnected) {
        int province = 0;
        int len = isConnected.length;
        boolean[] used = new boolean[len];
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                backtracking(i,used,isConnected);
                province++;
            }
        }
        return province;
    }

    private void backtracking(int index, boolean[] used, int[][] isConnected) {
        used[index] = true;
        int next = findNext(index,used,isConnected);
        while (next != -1) {
            backtracking(next,used,isConnected);
            next = findNext(index,used,isConnected);
        }
    }

    private int findNext(int index, boolean[] used, int[][] isConnected) {
        int[] ints = isConnected[index];
        for (int i = 0; i < ints.length; i++) {
            if (!used[i] && ints[i] == 1) {
                return i;
            }
        }
        return -1;
    }
}
