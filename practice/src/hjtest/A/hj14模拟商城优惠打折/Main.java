package hjtest.A.hj14模拟商城优惠打折;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] ints = getInts(input.nextLine());
            int count = Integer.parseInt(input.nextLine());
            int[] prices = getPrices(count, input);
            int fullTicket = ints[0];
            int cutTicket = ints[1];
            int noTicket = ints[2];
            Arrays.stream(prices)
                    .mapToObj((price)->getMinPrice(price,fullTicket,cutTicket, noTicket))
                    .forEach(System.out::println);
        }
        input.close();
    }

    private static MinPrice getMinPrice(int price, int fullTicket, int cutTicket, int noTicket) {
        MinPrice min01 = fullCut(price, fullTicket, cutTicket);
        MinPrice min02 = fullNo(price, fullTicket, noTicket);
        MinPrice min03 = cutNo(price, cutTicket, noTicket);
        return Stream.of(min01,min02,min03).min(new Comparator<MinPrice>() {
            @Override
            public int compare(MinPrice a, MinPrice b) {
                return a.price - b.price;
            }
        }).get();
    }

    private static MinPrice cutNo(int price, int cutTicket, int noTicket) {
        int ticket = 0;
        price = (int)(price * 0.92);
        ticket++;
        for (int i = 0; i < noTicket; i++) {
            price-=5;
            ticket++;
            if (price < 0) {
                price = 0;
                break;
            }
        }
        return new MinPrice(price, ticket);
    }

    private static MinPrice fullNo(int price, int fullTicket, int noTicket) {
        int ticket = 0;
        for (int i = 0; i < fullTicket; i++) {
            if (price >= 400) {
                price -= 40;
                ticket++;
                continue;
            }
            if (price >= 300) {
                price -= 30;
                ticket++;
                continue;
            }
            if (price >= 200) {
                price -= 20;
                ticket++;
                continue;
            }
            if (price >= 100) {
                price -= 10;
                ticket++;
            }
        }
        for (int i = 0; i < noTicket; i++) {
            price-=5;
            ticket++;
            if (price < 0) {
                price = 0;
                break;
            }
        }
        return new MinPrice(price, ticket);
    }

    private static MinPrice fullCut(int price, int fullTicket, int cutTicket) {
        int ticket = 0;
        for (int i = 0; i < fullTicket; i++) {
            if (price >= 400) {
                price -= 40;
                ticket++;
                continue;
            }
            if (price >= 300) {
                price -= 30;
                ticket++;
                continue;
            }
            if (price >= 200) {
                price -= 20;
                ticket++;
                continue;
            }
            if (price >= 100) {
                price -= 10;
                ticket++;
            }
        }
        price = (int)(price * 0.92);
        ticket++;
        return new MinPrice(price, ticket);
    }

    private static int[] getPrices(int count, Scanner input) {
        int[] prices = new int[count];
        int index = 0;
        while (index < count) {
            prices[index++] = Integer.parseInt(input.nextLine());
        }
        return prices;
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static class MinPrice {
        private final int price;
        private final int ticket;

        public MinPrice(int price, int ticket) {
            this.price = price;
            this.ticket = ticket;
        }

        @Override
        public String toString() {
            return price + " " + ticket;
        }
    }
}
