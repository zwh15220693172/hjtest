package hjtest.B复200分.hj23数据分类;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextInt()) {
            int c = input.nextInt();
            int mod = input.nextInt();
            int[] ints = getInts(input);
            HashMap<Integer,Integer> resultCount = new HashMap<>();
            for (int anInt : ints) {
                int cur = getNum(anInt) % mod;
                if (cur < c) {
                    resultCount.put(cur,resultCount.getOrDefault(cur,0)+1);
                }
            }
            int max = findMax(resultCount);
            System.out.println(max);
        }
        input.close();
    }

    private static int getNum(int anInt) {
        String hexString = Integer.toHexString(anInt);
        if (hexString.length() % 2 != 0) {
            hexString = "0" + hexString;
        }
        int sum = 0;
        for (int i = 0; i < hexString.length() - 1; i+=2) {
            sum += Integer.parseInt(hexString.substring(i,i+2),16);
        }
        return sum;
    }

    private static int findMax(HashMap<Integer, Integer> resultCount) {
        return resultCount.values().stream()
                .mapToInt(Integer::intValue)
                .max().getAsInt();
    }

    private static int[] getInts(Scanner input) {
        int[] ints = new int[10];
        for (int i = 0; i < 10; i++) {
            ints[i] = input.nextInt();
        }
        return ints;
    }
}
