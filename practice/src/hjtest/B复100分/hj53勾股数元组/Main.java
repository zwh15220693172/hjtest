package hjtest.B复100分.hj53勾股数元组;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextInt()) {
            int start = input.nextInt();
            int end = input.nextInt();
            List<Integer> res = new ArrayList<>();
            for (int i = start; i <= end; i++) {
                res.add(i * i);
            }
            HashSet<Integer> sumList = new HashSet<>(res);
            List<int[]> resultInts = new ArrayList<>();
            for (int i = 0; i < res.size(); i++) {
                for (int j = i + 1; j < res.size(); j++) {
                    int sum = res.get(i) + res.get(j);
                    if (sumList.contains(sum)) {
                        resultInts.add(new int[]{(int)Math.sqrt(res.get(i)),
                                (int)Math.sqrt(res.get(j)), (int)Math.sqrt(sum)});
                    }
                }
            }
            List<String> result = new ArrayList<>();
            for (int[] resultInt : resultInts) {
                if (noDivide(resultInt[0],resultInt[1])
                        && noDivide(resultInt[1],resultInt[2])
                        && noDivide(resultInt[0],resultInt[2])) {
                    result.add(resultInt[0] + " " + resultInt[1] + " " + resultInt[2]);
                }
            }
            if (result.isEmpty()) {
                System.out.println("NA");
            } else {
                result.forEach(System.out::println);
            }
        }
        input.close();
    }

    private static boolean noDivide(int x, int y) {
        while (y > 0) {
            int mod = x % y;
            x = y;
            y = mod;
        }
        return x == 1;
    }
}
