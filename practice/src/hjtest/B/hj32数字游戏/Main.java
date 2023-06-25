package hjtest.B.hj32数字游戏;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] countCard = getInts(input.nextLine());
            int count = countCard[0];
            int mod = countCard[1];
            int[] cards = getInts(input.nextLine());
            boolean result = getResult(mod, cards);
            System.out.println(result ? 1 : 0);
        }
        input.close();
    }

    private static boolean getResult(int mod, int[] cards) {
        int[] result = new int[mod];
        int cur = 0;
        for (int card : cards) {
            cur += card;
            cur %= mod;
            if (result[cur] == 1) {
                return true;
            }
            result[cur] = 1;
        }
        return false;
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
