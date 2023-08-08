package hjtest.B卷100分.hj19比赛的冠亚军;

import java.util.*;

/**
 * 超时没有100%
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            List<Player> listPlayer = listPlayer(input.nextLine());
            getResult(listPlayer);
        }
        input.close();
    }

    private static void getResult(List<Player> listPlayer) {
        int size = listPlayer.size();
        if (size == 4) {
            getResultFour(listPlayer);
        } else if (size == 3) {
            getResultThree(listPlayer);
        } else {
            List<Player> next = new ArrayList<>();
            int oneIndex = 0;
            int len = listPlayer.size();
            while (oneIndex < len) {
                if (oneIndex + 1 == len) {
                    next.add(listPlayer.get(oneIndex));
                } else {
                    Player one = listPlayer.get(oneIndex);
                    Player two = listPlayer.get(oneIndex+1);
                    if (one.biggerThan(two)) {
                        next.add(one);
                    } else {
                        next.add(two);
                    }
                }
                oneIndex+=2;
            }
            getResult(next);
        }
    }

    private static void getResultThree(List<Player> listPlayer) {
        Player player01 = listPlayer.get(0);
        Player player02 = listPlayer.get(1);
        Player three;
        Player next;
        if (player01.biggerThan(player02)) {
            next = player01;
            three = player02;
        } else {
            next = player02;
            three = player01;
        }
        Player player03 = listPlayer.get(2);
        Player one;
        Player two;
        if (player03.biggerThan(next)) {
            one = player03;
            two = next;
        } else {
            one = next;
            two = player03;
        }
        System.out.println(one.code + " " + two.code + " " + three.code);
    }

    private static void getResultFour(List<Player> listPlayer) {
        List<Player> win = new ArrayList<>();
        List<Player> lose = new ArrayList<>();
        int oneIndex = 0;
        int len = listPlayer.size();
        while (oneIndex < len) {
            Player one = listPlayer.get(oneIndex);
            Player two = listPlayer.get(oneIndex + 1);
            if (one.biggerThan(two)) {
                win.add(one);
                lose.add(two);
            } else {
                win.add(two);
                lose.add(one);
            }
            oneIndex+=2;
        }

        Player lose1 = lose.get(0);
        Player lose2 = lose.get(1);
        Player three;
        if (lose1.biggerThan(lose2)) {
            three = lose1;
        } else {
            three = lose2;
        }
        Player one;
        Player two;
        Player win01 = win.get(0);
        Player win02 = win.get(1);
        if (win01.biggerThan(win02)) {
            one = win01;
            two = win02;
        } else {
            one = win02;
            two = win01;
        }
        System.out.println(one.code + " " + two.code + " " + three.code);
    }

    private static List<Player> listPlayer(String nextLine) {
        int[] powers = Arrays.stream(nextLine.split(" ")).mapToInt(Integer::parseInt).toArray();
        List<Player> listPlayer = new ArrayList<>();
        for (int i = 0; i < powers.length; i++) {
            int power = powers[i];
            Player player = new Player(power,i);
            listPlayer.add(player);
        }
        return listPlayer;
    }

    private static class Player {
        private final int power;
        private final int code;

        public Player(int power, int code) {
            this.power = power;
            this.code = code;
        }

        public boolean biggerThan(Player other) {
            if (power == other.power) {
                return code < other.code;
            }
            return power > other.power;
        }
    }
}
