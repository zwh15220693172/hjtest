package hjtest.B.hj13比赛;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            List<Integer> mnList = listMn(input.nextLine());
            int m = mnList.get(0);
            int n = mnList.get(1);
            int[][] base = getBase(m, n, input);
            String result = getResult(m,n,base);
            System.out.println(result);
        }
        input.close();
    }

    private static String getResult(int m, int n, int[][] base) {
        if (errorParam(m,n,base)) {
            return "-1";
        }
        List<Player> listPlay = listPlay(m,n,base);
        List<String> resultList = new ArrayList<>();
        listPlay.stream().sorted(new Comparator<Player>() {
            @Override
            public int compare(Player a, Player b) {
                if (a.total == b.total) {
                    return moreHighPoint(a,b);
                } else {
                    return b.total - a.total;
                }
            }

            private int moreHighPoint(Player a, Player b) {
                int[] aPoints = a.points;
                int[] bPoints = b.points;
                int point = 10;
                int result = 0;
                while (point > 0) {
                    int aCount = getCount(aPoints,point);
                    int bCount = getCount(bPoints,point);
                    if (aCount == bCount) {
                        point--;
                    } else {
                        result = bCount - aCount;
                        break;
                    }
                }
                return result;
            }

            private int getCount(int[] points, int target) {
                int count = 0;
                for (int point : points) {
                    if (point == target) {
                        count++;
                    }
                }
                return count;
            }
        }).limit(3).map((player)->String.valueOf(player.code)).forEach(resultList::add);
        return String.join(",",resultList);
    }

    private static List<Player> listPlay(int m, int n, int[][] base) {
        List<Player> listPlay = new ArrayList<>();
        int code = 1;
        for (int i = 0; i < n; i++) {
            int[] points = new int[m];
            for (int j = 0; j < m; j++) {
                points[j] = base[j][i];
            }
            Player player = new Player(points,code++);
            listPlay.add(player);
        }
        return listPlay;
    }

    private static boolean errorParam(int m, int n, int[][] base) {
        if (m < 3) {
            return true;
        }
        if (n < 3) {
            return true;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (base[i][j] < 0 || base[i][j] > 10) {
                    return true;
                }
            }
        }
        return false;
    }

    private static int[][] getBase(int teacher, int student, Scanner input) {
        int[][] base = new int[teacher][student];
        int index = 0;
        while (index < teacher) {
            base[index++] = Arrays.stream(input.nextLine().split(","))
                    .mapToInt(Integer::parseInt).toArray();
        }
        return base;
    }

    private static List<Integer> listMn(String nextLine) {
        return Arrays.stream(nextLine.split(","))
                .map(Integer::parseInt).collect(Collectors.toList());
    }

    private static class Player {
        private final int[] points;
        private final int total;
        private final int code;

        public Player(int[] points, int code) {
            this.points = points;
            this.total = Arrays.stream(points).sum();
            this.code = code;
        }
    }
}
