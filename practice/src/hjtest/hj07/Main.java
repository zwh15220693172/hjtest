package hjtest.hj07;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String startAndEndStr = input.nextLine();
            int start = getStart(startAndEndStr);
            int end = getEnd(startAndEndStr);
            String[] numStrArray = new String[end-start+1];
            int index = 0;
            for (int i = start; i <= end; i++) {
                numStrArray[index++] = getNumStr(i);
            }
            int count = 0;
            for (String str : numStrArray) {
                if (!str.contains("101")) {
                    count++;
                }
            }
            System.out.println(count);
        }
        input.close();
    }

    private static String getNumStr(int num) {
        String result = "";
        while (num > 0) {
            result = num % 2 + result;
            num /= 2;
        }
        return result;
    }

    private static int getEnd(String startAndEndStr) {
        String[] splits = startAndEndStr.split(" ");
        return Integer.parseInt(splits[1]);
    }

    private static int getStart(String startAndEndStr) {
        String[] splits = startAndEndStr.split(" ");
        return Integer.parseInt(splits[0]);
    }
}
