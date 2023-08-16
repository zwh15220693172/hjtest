package hjtest.B复100分.hj111统计射击比赛成绩;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int len = Integer.parseInt(input.nextLine());
            int[] ids = getInts(input.nextLine());
            int[] scores = getInts(input.nextLine());
            HashMap<Integer,Player> playerMap = buildPlayerMap(len,ids, scores);
            Collection<Player> values = playerMap.values();
            List<Player> collect = values.stream().filter(Player::normal).collect(Collectors.toList());
            collect.forEach(Player::getTotal);
            String result = collect.stream().sorted(new Comparator<Player>() {
                @Override
                public int compare(Player a, Player b) {
                    if (a.total == b.total) {
                        return b.id - a.id;
                    }
                    return b.total - a.total;
                }
            }).map(Player::getId).collect(Collectors.joining(","));
            System.out.println(result);
        }
        input.close();
    }

    private static HashMap<Integer, Player> buildPlayerMap(int len, int[] ids, int[] scores) {
        HashMap<Integer,Player> playerMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int id = ids[i];
            int score = scores[i];
            Player player;
            if (!playerMap.containsKey(id)) {
                player = new Player(id);
                playerMap.put(id,player);
            } else {
                player = playerMap.get(id);
            }
            player.addScore(score);
        }
        return playerMap;
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(","))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static class Player {
        private final int id;
        private List<Integer> sources = new ArrayList<>();
        private int total;

        public Player(int id) {
            this.id = id;
        }

        public void addScore(int score) {
            this.sources.add(score);
        }

        public boolean normal() {
            return sources.size() >= 3;
        }

        public String getId() {
            return String.valueOf(id);
        }

        public void getTotal() {
            this.total = sources.stream().sorted(Comparator.reverseOrder())
                    .limit(3).mapToInt(Integer::intValue)
                    .sum();
        }
    }
}
