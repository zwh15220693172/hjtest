package hjtest;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] ints = getInts(input.nextLine());
            int c = ints[0];
            int b = ints[1];
            HashMap<Integer,Integer> modCount = new HashMap<>();
            for (int i = 2; i < ints.length; i++) {
                int cur = getCur(ints[i]);
                int mod = cur % b;
                if (mod < c) {
                    modCount.put(mod,modCount.getOrDefault(mod,0)+1);
                }
            }
            int max = modCount.values().stream()
                    .mapToInt(Integer::intValue).max()
                    .getAsInt();
            System.out.println(max);
        }
        input.close();
    }

    private static int getCur(int num) {
        int sum = 0;
        String hexString = Integer.toHexString(num);
        if (hexString.length() % 2 != 0) {
            hexString = "0" + hexString;
        }
        for (int i = 0; i <= hexString.length() - 2; i+=2) {
            String substring = hexString.substring(i, i + 2);
            int cur = Integer.parseInt(substring, 16);
            sum+=cur;
        }
        return sum;
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
