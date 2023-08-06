package hjtest.B.hj66冠军排名;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int count = Integer.parseInt(input.nextLine());
            List<Country> listCountry = listCountry(count,input);
            listCountry.stream().sorted(new Comparator<Country>() {
                @Override
                public int compare(Country a, Country b) {
                    if (a.goldMedal == b.goldMedal) {
                        if (a.silverMedal == b.silverMedal) {
                            if (b.bronzeMedal == a.bronzeMedal) {
                                return a.name.compareTo(b.name);
                            }
                            return b.bronzeMedal - a.bronzeMedal;
                        }
                        return b.silverMedal - a.silverMedal;
                    }
                    return b.goldMedal - a.goldMedal;
                }
            }).forEach(System.out::println);
        }
        input.close();
    }

    private static List<Country> listCountry(int count, Scanner input) {
        List<Country> listCountry = new ArrayList<>();
        while (count > 0) {
            String nextLine = input.nextLine();
            String[] splits = nextLine.split(" ");
            String name = splits[0];
            int goldMedal = Integer.parseInt(splits[1]);
            int silverMedal = Integer.parseInt(splits[2]);
            int bronzeMedal = Integer.parseInt(splits[3]);
            Country country = new Country(name, goldMedal, silverMedal, bronzeMedal);
            listCountry.add(country);
            count--;
        }
        return listCountry;
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

        public int getGoldMedal() {
            return goldMedal;
        }

        public int getSilverMedal() {
            return silverMedal;
        }

        public int getBronzeMedal() {
            return bronzeMedal;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
