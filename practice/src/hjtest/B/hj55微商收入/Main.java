package hjtest.B.hj55微商收入;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            Map<Integer,List<Seller>> parentMap = buildParentMap(input);
            Seller seller = new Seller(0, 0);
            int cash = getCash(seller,parentMap);
            System.out.println(cash);
        }
        input.close();
    }

    private static int getCash(Seller cur, Map<Integer, List<Seller>> parentMap) {
        if (Objects.isNull(cur)) {
            return 0;
        }
        int id = cur.id;
        if (!parentMap.containsKey(id)) {
            return cur.cash;
        }
        List<Seller> sellers = parentMap.get(id);
        int sum = 0;
        for (Seller child : sellers) {
            sum += getCash(child, parentMap);
        }
        return sum / 100 * 15 + cur.cash;
    }

    private static Map<Integer, List<Seller>> buildParentMap(Scanner input) {
        Map<Integer,List<Seller>> map = new HashMap<>();
        while (true) {
            String line = input.nextLine();
            if (line.isEmpty()) {
                break;
            }
            String[] splits = line.split(" ");
            Integer parent = Integer.parseInt(splits[1]);
            int id = Integer.parseInt(splits[0]);
            int cash = Integer.parseInt(splits[2]);
            Seller seller = new Seller(id,cash);
            List<Seller> child;
            if (map.containsKey(parent)) {
                child = map.get(parent);
            } else {
                child = new ArrayList<>();
                map.put(parent,child);
            }
            child.add(seller);
        }
        return map;
    }

    private static class Seller {
        private final int id;
        private final int cash;

        public Seller(int id, int cash) {
            this.id = id;
            this.cash = cash;
        }

        private final List<Seller> child = new ArrayList<>();

        public void addChild(Seller seller) {
            child.add(seller);
        }
    }
}
