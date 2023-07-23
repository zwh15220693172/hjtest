package hjtest.B复.hj07统计射击比赛成绩;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int len = Integer.parseInt(input.nextLine());
            int[] codes = getInts(input.nextLine());
            int[] scores = getInts(input.nextLine());
            HashMap<Integer,Player> codeMap = buildCodeMap(len, codes, scores);
            List<Player> list = listResult(codeMap);
            if (!list.isEmpty()) {
                String collect = list.stream().sorted(new Comparator<Player>() {
                            @Override
                            public int compare(Player a, Player b) {
                                if (a.total() == b.total()) {
                                    return b.code - a.code;
                                }
                                return b.total() - a.total();
                            }
                        }).map(Player::getCode).map(String::valueOf)
                        .collect(Collectors.joining(","));
                System.out.println(collect);
            }
        }
        input.close();
    }

    private static List<Player> listResult(HashMap<Integer, Player> codeMap) {
        Collection<Player> values = codeMap.values();
        return values.stream().filter(player -> player.scores.size() >= 3)
                .collect(Collectors.toList());
    }

    private static HashMap<Integer, Player> buildCodeMap(int len, int[] codes, int[] scores) {
        HashMap<Integer,Player> codeMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int code = codes[i];
            int score = scores[i];
            Player player;
            if (codeMap.containsKey(code)) {
                player = codeMap.get(code);
            } else {
                player = new Player(code);
                codeMap.put(code,player);
            }
            player.addScore(score);
        }
        return codeMap;
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(","))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static class Player {
        private final int code;
        private List<Integer> scores = new ArrayList<>();

        public Player(int code) {
            this.code = code;
        }
        public void addScore(int score) {
            this.scores.add(score);
        }

        public int getCode() {
            return code;
        }

        public int total() {
            if (scores.size() >= 3) {
                return scores.stream()
                        .sorted(Comparator.reverseOrder())
                        .limit(3)
                        .mapToInt(Integer::intValue)
                        .sum();
            }
            return 0;
        }
    }
}
