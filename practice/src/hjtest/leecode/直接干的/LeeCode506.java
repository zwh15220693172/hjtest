package hjtest.leecode.直接干的;

import java.util.*;

public class LeeCode506 {
    public String[] findRelativeRanks(int[] score) {
        List<Player> players = buildPlayers(score);
        players.sort(Comparator.comparing(Player::getSource).reversed());
        setResult(players);
        players.sort(Comparator.comparing(Player::getIndex));
        return players.stream().map(Player::getResult).toArray(String[]::new);
    }

    private void setResult(List<Player> players) {
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            if (i == 0) {
                player.setResult("Gold Medal");
            } else if (i == 1) {
                player.setResult("Silver Medal");
            } else if (i == 2) {
                player.setResult("Bronze Medal");
            } else {
                String result = String.valueOf((i+1));
                player.setResult(result);
            }
        }
    }

    private List<Player> buildPlayers(int[] score) {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            int source = score[i];
            Player player = new Player(source, i);
            players.add(player);
        }
        return players;
    }

    private final class Player {
        private int source;
        private int index;
        private String result;

        public Player(int source, int index) {
            this.source = source;
            this.index = index;
        }

        public int getSource() {
            return source;
        }

        public void setSource(int source) {
            this.source = source;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }
    }
}
