package hjtest.B卷100分.hj11恢复数字序列;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

/**
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String[] params = input.nextLine().split(" ");
            HashMap<Character,Integer> source = buildSource(params[0].toCharArray());
            int k = Integer.parseInt(params[1]);
            HashMap<Character,Integer> target = buildTarget(k);
            int result = getResult(source,target,k);
            System.out.println(result);
        }
        input.close();
    }

    private static int getResult(HashMap<Character, Integer> source, HashMap<Character, Integer> target, int k) {
        if (same(source,target)) {
            return 1;
        }
        for (int i = 1; i <= 1000 - k; i++) {
            char[] removes = String.valueOf(i).toCharArray();
            for (char remove : removes) {
                int count = target.get(remove);
                count--;
                target.put(remove,count);
            }
            char[] adds = String.valueOf(i+k).toCharArray();
            for (char add : adds) {
                target.put(add,target.getOrDefault(add,0)+1);
            }
            if (same(source,target)) {
                return i + 1;
            }
        }
        return -1;
    }

    private static boolean same(HashMap<Character, Integer> source, HashMap<Character, Integer> target) {
        Set<Character> keys = source.keySet();
        for (Character key : keys) {
            if (!target.containsKey(key)) {
                return false;
            }
            if (!Objects.equals(source.get(key), target.get(key))) {
                return false;
            }
        }
        return true;
    }

    private static HashMap<Character, Integer> buildTarget(int k) {
        HashMap<Character,Integer> target = new HashMap<>();
        for (int i = 1; i < 1 + k; i++) {
            char[] chars = String.valueOf(i).toCharArray();
            for (char cur : chars) {
                target.put(cur,target.getOrDefault(cur,0)+1);
            }
        }
        return target;
    }

    private static HashMap<Character, Integer> buildSource(char[] chars) {
        HashMap<Character,Integer> source = new HashMap<>();
        for (char cur : chars) {
            source.put(cur,source.getOrDefault(cur,0)+1);
        }
        return source;
    }
}
