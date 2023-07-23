package hjtest.B复.hj01德州扑克;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final int[] specially = {1,10,11,12,13};

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            List<Card> cards = listCard(input);
            printResult(cards);
        }
        input.close();
    }

    private static void printResult(List<Card> cards) {
        if (tongHuaShun(cards)) {
            System.out.println(1);
            System.out.println("同花顺");
        } else if (siTiao(cards)) {
            System.out.println(2);
            System.out.println("四条");
        } else if (huLu(cards)) {
            System.out.println(3);
            System.out.println("葫芦");
        } else if (tongHua(cards)) {
            System.out.println(4);
            System.out.println("同花");
        } else if (shunZi(cards)) {
            System.out.println(5);
            System.out.println("顺子");
        } else if (sanTiao(cards)) {
            System.out.println(6);
            System.out.println("三条");
        }
    }

    private static boolean sanTiao(List<Card> cards) {
        int[] array = getArray(cards);
        int sameCount = getMaxSameCount(array);
        int diffCount = getDiffCount(array);
        return sameCount == 3 && diffCount == 3;
    }

    private static boolean shunZi(List<Card> cards) {
        return lianXu(cards);
    }

    private static boolean tongHua(List<Card> cards) {
        return sameType(cards);
    }

    private static boolean huLu(List<Card> cards) {
        int[] array = getArray(cards);
        int diffCount = getDiffCount(array);
        return diffCount == 2;
    }

    private static int getDiffCount(int[] array) {
        int count = 1;
        int pre = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] != pre) {
                pre = array[i];
                count++;
            }
        }
        return count;
    }

    private static boolean siTiao(List<Card> cards) {
        int[] array = getArray(cards);
        int sameCount = getMaxSameCount(array);
        return sameCount == 4;
    }

    private static int getMaxSameCount(int[] array) {
        int count = 1;
        int pre = array[0];
        int result = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == pre) {
                count++;
            } else {
                result = Math.max(count,result);
                pre = array[i];
                count = 1;
            }
        }
        return result;
    }

    private static boolean tongHuaShun(List<Card> cards) {
        return sameType(cards) && lianXu(cards);
    }

    private static boolean lianXu(List<Card> cards) {
        int[] array = getArray(cards);
        if (Arrays.equals(array, specially)) {
            return true;
        }
        for (int i = 0; i < array.length - 1; i++) {
            int next = array[i+1];
            int cur = array[i];
            if (next - cur != 1) {
                return false;
            }
        }
        return true;
    }

    private static int[] getArray(List<Card> cards) {
       return cards.stream().mapToInt(Card::getNumber).sorted().toArray();
    }

    private static boolean sameType(List<Card> cards) {
        String type = cards.get(0).type;
        return cards.stream().allMatch(card -> card.getType().equals(type));
    }

    private static List<Card> listCard(Scanner input) {
        List<Card> listCard = new ArrayList<>();
        int count = 5;
        while (count > 0) {
            String inputStr = input.nextLine();
            String[] splits = inputStr.split(" ");
            int number = getNumber(splits[0]);
            String type = splits[1];
            Card card = new Card(number, type);
            listCard.add(card);
            count--;
        }
        return listCard;
    }

    private static int getNumber(String split) {
        if ("A".equals(split)) {
            return 1;
        } else if ("J".equals(split)) {
            return 11;
        } else if ("Q".equals(split)) {
            return 12;
        } else if ("K".equals(split)) {
            return 13;
        }
        return Integer.parseInt(split);
    }

    private static class Card {
        private final int number;
        private final String type;

        public Card(int number, String type) {
            this.number = number;
            this.type = type;
        }

        public int getNumber() {
            return number;
        }

        public String getType() {
            return type;
        }
    }
}
