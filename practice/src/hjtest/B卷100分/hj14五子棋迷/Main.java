package hjtest.B卷100分.hj14五子棋迷;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int target = Integer.parseInt(input.nextLine());
            int[] ints = getInts(input.nextLine());
            int len = ints.length;
            int mid = ints.length / 2;
            List<Integer> zeroIndex = getZeroIndex(ints);
            int result = -1;
            int max = 0;
            for (Integer index : zeroIndex) {
                int count = 0;
                int left = index - 1;
                while (left >= 0 && ints[left] == target) {
                    count++;
                    left--;
                }
                int right = index + 1;
                while (right < len && ints[right] == target) {
                    count++;
                    right++;
                }
                if (count > 0 && count <= 5) {
                    if (count >= max && Math.abs(index-mid) < Math.abs(result-mid)) {
                        result = index;
                        max = count;
                    }
                }
            }
            System.out.println(result);
        }
        input.close();
    }

    private static List<Integer> getZeroIndex(int[] ints) {
        List<Integer> zeroIndex = new ArrayList<>();
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] == 0) {
                zeroIndex.add(i);
            }
        }
        return zeroIndex;
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
