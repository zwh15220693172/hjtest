package HJ10;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            HashSet<Character> charSet = getCharSet(input.nextLine());
            System.out.println(charSet.size());
        }
        input.close();
    }

    private static HashSet<Character> getCharSet(String nextLine) {
        char[] inputChars = nextLine.toCharArray();
        HashSet<Character> charSet = new HashSet<>();
        for (char inputChar : inputChars) {
            charSet.add(inputChar);
        }
        return charSet;
    }
}
