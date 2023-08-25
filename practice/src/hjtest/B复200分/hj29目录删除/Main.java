package hjtest.B复200分.hj29目录删除;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextInt()) {
            int len = input.nextInt();
            int[][] ints = getInts(len,input);
            List<Integer> files = listFile(ints);
            HashMap<Integer,List<Integer>> fatherChildren = fatherChildren(ints);
            int start = input.nextInt();
            backtracking(start,fatherChildren,files);
            String collect = files.stream().sorted().map(String::valueOf)
                    .collect(Collectors.joining(" "));
            System.out.println(collect);
        }
        input.close();
    }

    private static void backtracking(int cur, HashMap<Integer, List<Integer>> fatherChildren,
                                     List<Integer> files) {
        files.remove(new Integer(cur));
        if (!fatherChildren.containsKey(cur)) {
            return;
        }
        List<Integer> childList = fatherChildren.get(cur);
        for (Integer child : childList) {
            backtracking(child,fatherChildren,files);
        }
    }

    private static HashMap<Integer, List<Integer>> fatherChildren(int[][] ints) {
        HashMap<Integer,List<Integer>> fatherChildren = new HashMap<>();
        for (int[] anInt : ints) {
            int child = anInt[0];
            int father = anInt[1];
            List<Integer> childList;
            if (fatherChildren.containsKey(father)) {
                childList = fatherChildren.get(father);
            } else {
                childList = new ArrayList<>();
                fatherChildren.put(father,childList);
            }
            childList.add(child);
        }
        return fatherChildren;
    }

    private static List<Integer> listFile(int[][] ints) {
        List<Integer> list = new ArrayList<>();
        for (int[] anInt : ints) {
            list.add(anInt[0]);
        }
        return list;
    }

    private static int[][] getInts(int len, Scanner input) {
        int[][] ints = new int[len][];
        int index = 0;
        while (index < len) {
            ints[index++] = new int[]{input.nextInt(), input.nextInt()};
        }
        return ints;
    }
}
