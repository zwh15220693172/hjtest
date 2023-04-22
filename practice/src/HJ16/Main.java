package HJ16;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String totalAndCountStr = input.nextLine();
            int total = getTotal(totalAndCountStr) / 10;
            int count = getCount(totalAndCountStr);
            Good[] goods = buildGoods(count, input);
            int m = goods.length;
            int n = total + 1;
            int[][] dp = new int[m][n];
            initialization(goods[0], dp, total);
            for (int i = 1; i < m; i++) {
                Good cur = goods[i];
                Good attach1 = cur.attach1;
                Good attach2 = cur.attach2;
                for (int j = 1; j <= total; j++) {
                    if (cur.v > j) {
                        dp[i][j] = dp[i-1][j];
                    } else {
                        if (noAttach(attach1, attach2)) {
                            dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-cur.v]+cur.satis());
                        } else if (twoAttach(attach1, attach2)) {
                            if ((cur.v + attach1.v > j) && (cur.v + attach2.v > j)) {
                                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-cur.v]+cur.satis());
                            } else if ((cur.v + attach1.v + attach2.v <= j)) {
                                dp[i][j] = Math.max(Math.max(Math.max(dp[i-1][j], dp[i-1][j-cur.v]+cur.satis()),
                                        dp[i-1][j-cur.v-attach1.v] + cur.satis() + attach1.satis()),
                                        dp[i-1][j-cur.v-attach1.v-attach2.v] + cur.satis() + attach1.satis() + attach2.satis());
                            } else if ((cur.v + attach1.v <= j) && (cur.v + attach2.v > j)) {
                                dp[i][j] = Math.max(Math.max(dp[i-1][j], dp[i-1][j-cur.v] + cur.satis()),dp[i-1][j-cur.v-attach1.v] + cur.satis() + attach1.satis());
                            } else {
                                dp[i][j] = Math.max(Math.max(dp[i-1][j], dp[i-1][j-cur.v] + cur.satis()),dp[i-1][j-cur.v-attach2.v] + cur.satis() + attach2.satis());
                            }
                        } else {
                            if (cur.v + attach1.v <= j) {
                                dp[i][j] = Math.max(Math.max(dp[i-1][j], dp[i-1][j-cur.v] + cur.satis()),dp[i-1][j-cur.v-attach1.v] + cur.satis() + attach1.satis());
                            } else {
                                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-cur.v]+cur.satis());
                            }
                        }
                    }
                }
            }
            int result = dp[m - 1][n - 1] * 10;
            System.out.println(result);
        }
        input.close();
    }

    private static void initialization(Good good, int[][] dp, int total) {
        Good attach1 = good.attach1;
        Good attach2 = good.attach2;
        for (int i = good.v; i <= total; i++) {
            if (noAttach(attach1, attach2)) {
                dp[0][i] = good.satis();
            } else if (twoAttach(attach1,attach2)) {
                if ((good.v + attach1.v > i) && (good.v + attach2.v > i)) {
                    dp[0][i] = good.satis();
                } else if (good.v + attach1.v + attach2.v <= i) {
                    dp[0][i] = good.satis() + attach1.satis() + attach2.satis();
                } else if ((good.v + attach1.v <= i) && (good.v + attach2.v > i)) {
                    dp[0][i] = good.satis() + attach1.satis();
                } else {
                    dp[0][i] = good.satis() + attach2.satis();
                }
            } else {
                if (good.v + attach1.v <= i) {
                    dp[0][i] = good.satis() + attach1.satis();
                } else {
                    dp[0][i] = good.satis();
                }
            }
        }
    }

    private static boolean noAttach(Good attach1, Good attach2) {
        return Objects.isNull(attach1) && Objects.isNull(attach2);
    }

    private static boolean twoAttach(Good attach1, Good attach2) {
        return Objects.nonNull(attach1) && Objects.nonNull(attach2);
    }

    private static Good[] buildGoods(int count, Scanner input) {
        List<Good> sources = buildSource(count, input);
        setAttach(sources);
        return sources.stream().filter(Good::isPrinciple).toArray(Good[]::new);
    }

    private static void setAttach(List<Good> sources) {
        for (Good source : sources) {
            if (source.isPrinciple()) {
                continue;
            }
            int index = source.q - 1;
            Good principle = sources.get(index);
            if (Objects.isNull(principle.attach1)) {
                principle.attach1 = source;
            } else {
                principle.attach2 = source;
            }
        }
    }

    private static List<Good> buildSource(int count, Scanner input) {
        List<Good> sources = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String line = input.nextLine();
            String[] splits = line.split(" ");
            Good good = new Good(
                    Integer.parseInt(splits[0]) / 10,
                    Integer.parseInt(splits[1]),
                    Integer.parseInt(splits[2]));
            sources.add(good);
        }
        return sources;
    }

    private static int getCount(String totalAndCountStr) {
        String[] splits = totalAndCountStr.split(" ");
        return Integer.parseInt(splits[1]);
    }

    private static int getTotal(String totalAndCountStr) {
        String[] splits = totalAndCountStr.split(" ");
        return Integer.parseInt(splits[0]);
    }

    private static class Good {
        private final int v;
        private final int p;
        private final int q;

        private Good attach1;
        private Good attach2;

        public Good(int v, int p, int q) {
            this.v = v;
            this.p = p;
            this.q = q;
        }

        public boolean isPrinciple() {
            return q == 0;
        }

        public int satis() {
            return this.v * this.p;
        }
    }
}
