package hjtest.B.hj28数据分类;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] ints = getInts(input.nextLine());
            int target = ints[0];
            int mod = ints[1];
            Map<Integer,Integer> numCount = new HashMap<>();
            for (int i = 2; i < ints.length; i++) {
                int num = getNum(ints[i]);
                int result = num % mod;
                if (result < target) {
                    numCount.put(result,numCount.getOrDefault(result,0)+1);
                }
            }
            Collection<Integer> values = numCount.values();
            int max = 0;
            for (Integer value : values) {
                max = Math.max(max,value);
            }
            System.out.println(max);
        }
        input.close();
    }

    private static int getNum(int num) {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += (byte)(num >> (i * 8));
        }
        return sum;
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
