package hjtest.B.hj21阿里巴巴的黄金宝箱3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] ints = getInts(input.nextLine());
            int len = Integer.parseInt(input.nextLine());
            int result = -1;
            for (int i = 0; i < ints.length; i++) {
                for (int j = i + 1; j < ints.length; j++) {
                    if (ints[i] == ints[j]) {
                        int cur = j - i;
                        if (cur <= len) {
                            result = i;
                            break;
                        }
                    }
                }
            }
            System.out.println(result);
        }
        input.close();
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(","))
                .mapToInt(Integer::parseInt).toArray();
    }
}
