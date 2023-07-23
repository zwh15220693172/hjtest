package hjtest.B复.hj04事件推送;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] params = getInts(input.nextLine());
            int R = params[2];
            int[] aInts = getInts(input.nextLine());
            int[] bInts = getInts(input.nextLine());
            int aIndex = 0;
            int bIndex = 0;
            List<String> result = new ArrayList<>();
            while (aIndex < aInts.length && bIndex < bInts.length) {
                if (bIndex >= aIndex
                        && bInts[bIndex] >=  aInts[aIndex]
                        && bInts[bIndex] - aInts[aIndex] <= R) {
                    result.add(aInts[aIndex] + " " + bInts[bIndex]);
                    aIndex++;
                }
                bIndex++;
            }
            result.forEach(System.out::println);
        }
        input.close();
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
