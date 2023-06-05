package hjtest.B.hj8座位调整;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] ints = getInts(input.nextLine());
            int count = getCount(ints);
            System.out.println(count);
        }
        input.close();
    }

    private static int getCount(int[] ints) {
        if (ints.length == 1) {
            return ints[0] == 0 ? 1 : 0;
        }
        int count = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] != 0) {
                continue;
            }
            if (i == 0) {
                if (ints[i+1] == 0) {
                    ints[i] = 1;
                    count++;
                }
            } else if (i == ints.length - 1) {
                if (ints[i-1] == 0) {
                    ints[i] = 1;
                    count++;
                }
            } else {
                if (ints[i-1] == 0 && ints[i+1] == 0) {
                    ints[i] = 1;
                    count++;
                }
            }
        }
        return count;
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(","))
                .mapToInt(Integer::parseInt).toArray();
    }
}
