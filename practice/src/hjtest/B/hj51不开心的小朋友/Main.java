package hjtest.B.hj51不开心的小朋友;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int playSize = Integer.parseInt(input.nextLine());
            Player[] players = getPlayers(input.nextLine());
            List<Player> playing = new ArrayList<>();
            LinkedList<Player> waiting = new LinkedList<>();
            int unHappy = 0;
            for (Player player : players) {
                if (playing.size() < playSize && !playing.contains(player)) {
                    playing.add(player);
                } else if (playing.contains(player)) {
                    playing.remove(player);
                    if (!waiting.isEmpty()) {
                        playing.add(waiting.poll());
                    }
                } else {
                    if (waiting.contains(player)) {
                        waiting.remove(player);
                        unHappy++;
                    } else {
                        waiting.add(player);
                    }
                }
            }
            System.out.println(unHappy);
        }
        input.close();
    }

    private static Player[] getPlayers(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt)
                .mapToObj(Player::new)
                .toArray(Player[]::new);
    }

    private static class Player {
        private final int id;

        public Player(int id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Player)) {
                return false;
            }
            Player other = (Player) obj;
            return this.id == other.id;
        }
    }
}
