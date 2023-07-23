package hjtest.B复.hj06补活未成活胡杨;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int len = Integer.parseInt(input.nextLine());
            int[] indexList = getIndexList(input);
            int k = Integer.parseInt(input.nextLine());
            int zeroCount = 0;
            int[] ints = getInts(len, indexList);
            int left = 0;
            int right = 0;
            int max = Integer.MIN_VALUE;
            while (right < len) {
                if (ints[right] == 0) {
                    zeroCount++;
                    while (left < right && zeroCount > k) {
                        if (ints[left] == 0) {
                            zeroCount--;
                        }
                        left++;
                    }
                }
                int cur = right - left + 1;
                max = Math.max(cur,max);
                right++;
            }
            System.out.println(max);
        }
        input.close();
    }

    private static int[] getInts(int len, int[] indexList) {
        int[] ints = new int[len];
        Arrays.fill(ints,1);
        for (int index : indexList) {
            ints[index-1] = 0;
        }
        return ints;
    }

    private static int[] getIndexList(Scanner input) {
        int length = Integer.parseInt(input.nextLine());
        return Arrays.stream(input.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
