package hjtest.B卷200分.hj25不开心的小朋友;

import java.util.*;

/**
 * 100%通过，记住以下步骤缺一不可
 * 1.如果waitting包含，那么unhappy++并且，waitting把player删除,continue
 * 2.如果playing包含，那么playing把player删掉，如果waitting不为空，那么waitting弹出队列第一个给playing，continue
 * 3.如果playing比最大长度小，那么添加
 * 4.否则加进去waitting
 */
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
                if (waiting.contains(player)) {
                    waiting.remove(player);
                    unHappy++;
                    continue;
                }
                if (playing.contains(player)) {
                    playing.remove(player);
                    if (!waiting.isEmpty()) {
                        playing.add(waiting.poll());
                    }
                    continue;
                }
                if (playing.size() < playSize) {
                    playing.add(player);
                } else {
                    waiting.add(player);
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
