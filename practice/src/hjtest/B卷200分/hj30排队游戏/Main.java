package hjtest.B卷200分.hj30排队游戏;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextInt()) {
            int len = input.nextInt();
            int bad = input.nextInt();
            int total = input.nextInt();
            List<Integer> badList = buildBadList(bad,input);
            int[] array = buildArray(len,input);
            int sum = 0;
            for (int i = 0; i < array.length; i++) {
                if (badList.contains(i)) {
                    continue;
                }
                int cur = array[i];
                int k = 0;
                for (int j = 0; j < i; j++) {
                    if (array[j] > cur) {
                        k++;
                    }
                }
                sum+=k;
            }
            if (sum > total) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
        input.close();
    }

    private static int[] buildArray(int len, Scanner input) {
        int[] array = new int[len];
        int index = 0;
        while (index < len) {
            array[index++] = input.nextInt();
        }
        return array;
    }

    private static List<Integer> buildBadList(int bad,Scanner input) {
        List<Integer> badList = new ArrayList<>();
        while (bad > 0) {
            badList.add(input.nextInt());
            bad--;
        }
        return badList;
    }
}
