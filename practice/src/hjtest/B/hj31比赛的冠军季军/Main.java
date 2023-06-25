package hjtest.B.hj31比赛的冠军季军;

import java.util.*;

public class Main {
    private static final PlayerComparator comparator = new PlayerComparator();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] ints = getInts(input.nextLine());
            List<Player> listPlay = listPlay(ints);
            listGames(listPlay);
        }
        input.close();
    }

    private static List<Player> listPlay(int[] ints) {
        List<Player> listPlay = new ArrayList<>();
        for (int i = 0; i < ints.length; i++) {
            listPlay.add(new Player(i,ints[i]));
        }
        return listPlay;
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static void listGames(List<Player> players) {
        if (players.size() == 3) {
            threePlayers(players);
        } else if (players.size() == 4) {
            fourPlayers(players);
        } else {
            listPlayers(players);
        }
    }

    private static void listPlayers(List<Player> players) {
        List<Player> nextPlayers = new ArrayList<>();
        for (int i = 0; i < players.size(); i+=2) {
            if (i == players.size() - 1) {
                nextPlayers.add(players.get(i));
            } else {
                Player one = players.get(i);
                Player two = players.get(i + 1);
                if (one.biggerThan(two)) {
                    nextPlayers.add(one);
                } else {
                    nextPlayers.add(two);
                }
            }
        }
        listGames(nextPlayers);
    }

    private static void fourPlayers(List<Player> players) {
        List<Player> win = new ArrayList<>();
        List<Player> lose = new ArrayList<>();
        int index1 = 0;
        int index2 = 1;
        while (index1 < 4 && index2 < 4) {
            Player one = players.get(index1);
            Player two = players.get(index2);
            if (one.biggerThan(two)) {
                win.add(one);
                lose.add(two);
            } else {
                win.add(two);
                lose.add(one);
            }
            index1+=2;
            index2+=2;
        }
        win.sort(comparator);
        Player first = win.get(0);
        Player second = win.get(1);
        lose.sort(comparator);
        Player third = lose.get(0);
        System.out.println(first.id + " " + second.id + " " + third.id);
    }

    private static void threePlayers(List<Player> players) {
        Player one = players.get(0);
        Player two = players.get(1);
        Player three = players.get(2);
        Player first;
        Player second;
        Player third;
        if (one.biggerThan(two)) {
            if (one.biggerThan(three)) {
                first = one;
                second = three;
            } else {
                first = three;
                second = one;
            }
            third = two;
        } else {
            if (two.biggerThan(three)) {
                first = two;
                second = three;
            } else {
                first = three;
                second = two;
            }
            third = one;
        }
        System.out.println(first.id + " " + second.id + " " + third.id);
    }

    private static class PlayerComparator implements Comparator<Player> {

        @Override
        public int compare(Player a, Player b) {
            return b.val - a.val;
        }
    }


    private static class Player {
        private final int id;
        private final int val;

        public Player(int id, int val) {
            this.id = id;
            this.val = val;
        }

        public boolean biggerThan(Player other) {
            return val > other.val;
        }
    }
}
