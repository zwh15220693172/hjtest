package hjtest.B卷100分.hj23跳房子;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 100%通过
 * 注意：顺序保持数组中原有的顺序
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] ints = getInts(input.nextLine());
            int target = Integer.parseInt(input.nextLine());
            HashMap<Integer,Integer> numIndex = new HashMap<>();
            int resultIndex = Integer.MAX_VALUE;
            int[] result = new int[2];
            for (int i = 0; i < ints.length; i++) {
                int cut = target - ints[i];
                if (numIndex.containsKey(cut)) {
                    int last = numIndex.get(cut);
                    if (last + i < resultIndex) {
                        resultIndex = last + i;
                        result = new int[]{cut, ints[i]};
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
        String substring = nextLine.substring(1, nextLine.length() - 1);
        return Arrays.stream(substring.split(","))
                .mapToInt(Integer::parseInt).toArray();
    }
}
