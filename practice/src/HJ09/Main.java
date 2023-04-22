package HJ09;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String numStr = input.nextLine();
            LinkedHashSet<Character> numSet = buildNumSet(numStr);
            printNumSet(numSet);
        }
        input.close();
    }

    private static void printNumSet(LinkedHashSet<Character> numSet) {
        String result = numSet.stream().map(String::valueOf).collect(Collectors.joining());
        System.out.println(result);
    }

    private static LinkedHashSet<Character> buildNumSet(String numStr) {
        char[] chars = numStr.toCharArray();
        LinkedHashSet<Character> hashSet = new LinkedHashSet<>();
        for (int i = chars.length - 1; i >= 0; i--) {
            hashSet.add(chars[i]);
        }
        return hashSet;
    }
}
