package HJ08;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int count = getCount(input);
            Map<Integer,Integer> res = new HashMap<>();
            for (int i = 0; i < count; i++) {
                String inputLine = input.nextLine();
                String[] strings = inputLine.split(" ");
                int index = getIndex(strings);
                int number = getNumber(strings);
                if (res.containsKey(index)) {
                    int value = res.get(index);
                    value += number;
                    res.put(index,value);
                } else {
                    res.put(index,number);
                }
            }
            res.entrySet().stream().sorted(Map.Entry.comparingByKey())
                    .forEach((entry) -> System.out.println(entry.getKey() + " " + entry.getValue()));
        }
        input.close();
    }

    private static int getNumber(String[] strings) {
        return Integer.parseInt(strings[1]);
    }

    private static int getIndex(String[] strings) {
        return Integer.parseInt(strings[0]);
    }



    private static int getCount(Scanner input) {
        String inputStr = input.nextLine();
        return Integer.parseInt(inputStr);
    }
}
