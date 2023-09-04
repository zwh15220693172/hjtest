package hjtest;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int maxSize = Integer.parseInt(input.nextLine());
        List<Player> idList = idList(input.nextLine());
        List<Player> playing = new ArrayList<>();
        LinkedList<Player> waiting = new LinkedList<>();
        int unHappy = 0;
        for (Player cur : idList) {
            if (waiting.contains(cur)) {
                waiting.remove(cur);
                unHappy++;
                continue;
            }
            if (playing.contains(cur)) {
                playing.remove(cur);
                if (!waiting.isEmpty()) {
                    playing.add(waiting.poll());
                }
                continue;
            }
            if (playing.size() < maxSize) {
                playing.add(cur);
            } else {
                waiting.addLast(cur);
            }
        }
        System.out.println(unHappy);
        input.close();
    }

    private static List<Player> idList(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .map(Integer::parseInt).map(Player::new)
                .collect(Collectors.toList());
    }

    private static class Player {
        private final int id;

        public Player(int id) {
            this.id = id;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (!(obj instanceof Player)) {
                return false;
            }
            Player other = (Player) obj;
            return id == other.id;
        }
    }
}
