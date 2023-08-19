package hjtest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        int unHappy = 0;
        List<Player> playing = new ArrayList<>();
        LinkedList<Player> waiting = new LinkedList<>();
        Player[] players = new Player[0];
        for (Player player : players) {
            if (waiting.contains(player)) {
                waiting.remove(player);
                unHappy++;
                continue;
            }
            if (playing.contains(player)) {
                playing.remove(player);
                if (waiting.isEmpty()) {
                    playing.add(waiting.poll());
                }
                continue;
            }
        }
    }

    private static class Player {
        private int id;
    }
}
