package hjtest.B复100分.hj77冠亚军排名;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int len = Integer.parseInt(input.nextLine());
        List<Country> listCountry = listCountry(len,input);
        listCountry.stream().sorted(new Comparator<Country>() {
            @Override
            public int compare(Country a, Country b) {
                if (a.goldMedal == b.goldMedal) {
                    if (b.silverMedal == a.silverMedal) {
                        if (b.bronzeMedal == a.bronzeMedal) {
                            return a.name.compareTo(b.name);
                        }
                        return b.bronzeMedal - a.bronzeMedal;
                    }
                    return b.silverMedal - a.silverMedal;
                }
                return b.goldMedal - a.goldMedal;
            }
        }).map(Country::getName).forEach(System.out::println);
    }

    private static List<Country> listCountry(int len, Scanner input) {
        List<Country> listCountry = new ArrayList<>();
        while (len > 0) {
            Country country = getCountry(input.nextLine());
            listCountry.add(country);
            len--;
        }
        return listCountry;
    }

    private static Country getCountry(String nextLine) {
        String[] splits = nextLine.split(" ");
        String name = splits[0];
        int goldMedal = Integer.parseInt(splits[1]);
        int silverMedal = Integer.parseInt(splits[2]);
        int bronzeMedal = Integer.parseInt(splits[3]);
        return new Country(name, goldMedal, silverMedal, bronzeMedal);
    }

    private static class Country {
        private final String name;
        private final int goldMedal;
        private final int silverMedal;
        private final int bronzeMedal;

        public Country(String name, int goldMedal, int silverMedal, int bronzeMedal) {
            this.name = name;
            this.goldMedal = goldMedal;
            this.silverMedal = silverMedal;
            this.bronzeMedal = bronzeMedal;
        }

        public String getName() {
            return name;
        }
    }
}
