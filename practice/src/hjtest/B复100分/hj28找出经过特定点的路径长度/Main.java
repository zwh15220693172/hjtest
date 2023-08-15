package hjtest.B复100分.hj28找出经过特定点的路径长度;

import java.util.*;

public class Main {
    private static final LinkedList<Integer> path = new LinkedList<>();

    private static int result;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            path.clear();
            result = Integer.MAX_VALUE;
            char[] source = input.nextLine().toCharArray();
            char[] target = input.nextLine().toCharArray();
            HashMap<Integer, List<Integer>> indexList = buildIndexList(source,target);
            getResult(0,target.length,indexList);
            System.out.println(result);
        }
        input.close();
    }

    private static void getResult(int index, int length, HashMap<Integer, List<Integer>> indexList) {
        if (index == length) {
            int pre = 0;
            int sum = 0;
            for (int cur : path) {
                sum += Math.abs(cur - pre);
                pre = cur;
            }
            result = Math.min(sum,result);
            return;
        }
        List<Integer> indexArray = indexList.get(index);
        for (Integer curIndex : indexArray) {
            path.addLast(curIndex);
            getResult(index+1,length,indexList);
            path.removeLast();
        }
    }

    private static HashMap<Integer, List<Integer>> buildIndexList(char[] source, char[] target) {
        HashMap<Integer,List<Integer>> indexList = new HashMap<>();
        for (int i = 0; i < target.length; i++) {
            List<Integer> curIndex = new ArrayList<>();
            int cur = target[i];
            for (int j = 0; j < source.length; j++) {
                if (source[j] == cur) {
                    curIndex.add(j);
                }
            }
            indexList.put(i,curIndex);
        }
        return indexList;
    }
}
