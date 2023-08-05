package hjtest.B.hj48拔河比赛;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            List<Player> listPlayer = listPlayer(input);
            listPlayer.stream().sorted(new Comparator<Player>() {
                @Override
                public int compare(Player a, Player b) {
                    if (a.height == b.height) {
                        return b.weight - a.weight;
                    }
                    return b.height - a.height;
                }
            }).limit(10).forEach(System.out::println);
        }
        input.close();
    }

    private static List<Player> listPlayer(Scanner input) {
        List<Player> listPlayer = new ArrayList<>();
        while (true) {
            String line = input.nextLine();
            if (line.isEmpty()) {
                break;
            }
            Player player = createPlayer(line);
            listPlayer.add(player);
        }
        return listPlayer;
    }

    private static Player createPlayer(String line) {
        String[] splits = line.split(" ");
        int height = Integer.parseInt(splits[0]);
        int weight = Integer.parseInt(splits[1]);
        return new Player(height, weight);
    }

    private static class Player {
        private final int height;
        private final int weight;

        public Player(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return this.height + " " + this.weight;
        }
    }
}
