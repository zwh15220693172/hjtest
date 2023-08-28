package hjtest.B卷200分.hj29人气最高的店铺;

import java.util.*;

public class Main {
    private static int min;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            min = Integer.MAX_VALUE;
            int[] params = getParams(input.nextLine());
            int people_num = params[0];
            int shop_num = params[1];
            int[] shop = new int[shop_num+1];
            List<Shop> listShop = listShop(people_num,shop,input);
            listShop.sort(new Comparator<Shop>() {
                @Override
                public int compare(Shop a, Shop b) {
                    return a.money - b.money;
                }
            });
            if (maxTicket(shop)) {
                System.out.println(0);
            } else {
                backtracking(0,0,listShop,shop);
                System.out.println(min);
            }
        }
        input.close();
    }

    private static void backtracking(int index, int sum,List<Shop> listShop, int[] shop) {
        if (maxTicket(shop)) {
            min = Math.min(sum,min);
            return;
        }
        for (int i = index; i < listShop.size(); i++) {
            Shop cur = listShop.get(i);
            if (cur.money > min || sum + cur.money > min) {
                break;
            }
            shop[cur.id]--;
            shop[1]++;
            backtracking(i+1,sum+ cur.money,listShop,shop);
            shop[1]--;
            shop[cur.id]++;
        }
    }

    private static boolean maxTicket(int[] shop) {
        for (int i = 2; i < shop.length; i++) {
            if (shop[i] >= shop[1]) {
                return false;
            }
        }
        return true;
    }


    private static List<Shop> listShop(int people_num, int[] shop, Scanner input) {
        List<Shop> list = new ArrayList<>();
        while (people_num > 0) {
            String[] splits = input.nextLine().split(",");
            int id = Integer.parseInt(splits[0]);
            int money = Integer.parseInt(splits[1]);
            if (id != 1) {
                Shop cur = new Shop(id,money);
                list.add(cur);
            }
            shop[id]++;
            people_num--;
        }
        return list;
    }

    private static int[] getParams(String nextLine) {
        return Arrays.stream(nextLine.split(","))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static class Shop {
        private final int id;
        private final int money;

        public Shop(int id, int money) {
            this.id = id;
            this.money = money;
        }

        public int getId() {
            return id;
        }

        public int getMoney() {
            return money;
        }
    }
}
