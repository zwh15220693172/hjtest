package hjtest.B.hj11最长公共后缀;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String inputStr = input.nextLine();
            String[] strings = getArray(inputStr);
            StringBuilder result = new StringBuilder();
            int count = 1;
            String min = findMin(strings);
            int len = min.length();
            while (len - count >= 0) {
                char target = min.charAt(len - count);
                boolean sameChar = true;
                for (String string : strings) {
                    char cur = string.charAt(string.length()-count);
                    if (target != cur) {
                        sameChar = false;
                        break;
                    }
                }
                if (!sameChar) {
                    break;
                }
                result.append(target);
                count++;
            }
            if (result.length() == 0) {
                System.out.println("@Zero");
            } else {
                System.out.println(result.reverse().toString());
            }
        }
        input.close();
    }

    private static String findMin(String[] strings) {
        return Arrays.stream(strings).min(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.length() - b.length();
            }
        }).get();
    }

    private static String[] getArray(String inputStr) {
        String substring = inputStr.substring(1, inputStr.length() - 1);
        String[] splits = substring.split(",");
        String[] array = new String[splits.length];
        for (int i = 0; i < splits.length; i++) {
            array[i] = splits[i].substring(1,splits[i].length()-1);
        }
        return array;
    }
}
