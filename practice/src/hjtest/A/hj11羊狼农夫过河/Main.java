package hjtest.A.hj11羊狼农夫过河;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int result;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            result = Integer.MAX_VALUE;
            int[] ints = getInts(input.nextLine());
            int sheep = ints[0];
            int wolf = ints[1];
            int ship = ints[2];
            int sheep_move = 0;
            int wolf_move = 0;
            int time = 0;
            move(sheep, wolf, ship, sheep_move, wolf_move, time);
            if (result == Integer.MAX_VALUE) {
                System.out.println(0);
            } else {
                System.out.println(result);
            }
        }
        input.close();
    }

    private static void move(int sheep, int wolf, int ship, int sheep_move, int wolf_move, int time) {
        if (ship >= sheep + wolf) {
            time = time + 1;
            if (time < result) {
                result = time;
            }
            return;
        }
        for (int i = 0; i <= sheep && i <= ship; i++) {
            for (int j = 0; j <= wolf && i + j <= ship; j++) {
                if (i + j == 0) {
                    continue;
                }
                if ((sheep - i > wolf - j) && (sheep_move + i > wolf_move + j)) {
                    move(sheep - i , wolf - j, ship, sheep_move + i, wolf_move + j, time + 1);
                }
            }
        }
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
