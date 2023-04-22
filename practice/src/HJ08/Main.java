package HJ08;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int count = readCount(input);
            Map<Integer, Integer> indexValueMap = new HashMap<>();
            for (int i = 0; i < count; i++) {
                saveDataStr(indexValueMap,input.nextLine());
            }
            printIndexValueMap(indexValueMap);
        }
        input.close();
    }

    private static void printIndexValueMap(Map<Integer, Integer> indexValueMap) {
        indexValueMap.entrySet()
                .stream().sorted(Map.Entry.comparingByKey())
                .forEach((entry)->System.out.println(entry.getKey() + " " + entry.getValue()));
    }

    private static void saveDataStr(Map<Integer, Integer> indexValueMap, String nextLine) {
        String[] strData = nextLine.split(" ");
        int index = Integer.parseInt(strData[0]);
        int value = Integer.parseInt(strData[1]);
        if (indexValueMap.containsKey(index)) {
            int baseValue = indexValueMap.get(index);
            int inputValue = baseValue + value;
            indexValueMap.put(index, inputValue);
        } else {
            indexValueMap.put(index, value);
        }
    }

    private static int readCount(Scanner input) {
        String countLine = input.nextLine();
        return Integer.parseInt(countLine);
    }
}
