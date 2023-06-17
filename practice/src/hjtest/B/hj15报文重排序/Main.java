package hjtest.B.hj15报文重排序;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int count = Integer.parseInt(input.nextLine());
            String[] inputStr = input.nextLine().split(" ");
            String result = getResult(inputStr, count);
            System.out.println(result);
        }
        input.close();
    }

    private static String getResult(String[] inputStrArray, int count) {
        String[] outputStr = new String[count];
        for (String command : inputStrArray) {
            int numIndex = getNumIndex(command);
            String str = command.substring(0,numIndex);
            int index = Integer.parseInt(command.substring(numIndex));
            outputStr[index-1] = str;
        }
        return String.join(" ", outputStr);
    }

    private static int getNumIndex(String command) {
        char[] chars = command.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                return i;
            }
        }
        return -1;
    }
}
