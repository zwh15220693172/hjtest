package hjtest.B.hj44跳房子1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] ints = getInts(input.nextLine());
            int target = Integer.parseInt(input.nextLine());
            int[] result = new int[2];
            int resultIndex = Integer.MAX_VALUE;
            HashMap<Integer,Integer> numIndex = new HashMap<>();
            for (int i = 0; i < ints.length; i++) {
                int cur = target - ints[i];
                if (numIndex.containsKey(cur)) {
                    int last = numIndex.get(cur);
                    int curResult = last + i;
                    if (curResult < resultIndex) {
                        resultIndex = curResult;
                        result = new int[]{ints[i],cur};
                    }
                } else {
                    numIndex.put(ints[i], i);
                }
            }
            System.out.println(Arrays.toString(result));
        }
        input.close();
    }

    private static int[] getInts(String nextLine) {
        String replace = nextLine.replace("[", "")
                .replace("]", "");
        return Arrays.stream(replace.split(","))
                .mapToInt(Integer::parseInt).toArray();
    }
}
