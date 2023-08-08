package hjtest.B卷100分.hj15报文重排序;

import java.util.Scanner;

/**
 * 有超时的
 */
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
            StringBuilder digitStr = new StringBuilder();
            int index = -1;
            for (int i = command.length() - 1 ; i >= 0; i--) {
                if (Character.isDigit(command.charAt(i))) {
                    digitStr.insert(0, command.charAt(i));
                } else {
                    index = i;
                    break;
                }
            }
            String string = command.substring(0,index+1);
            int outputIndex = Integer.parseInt(digitStr.toString()) - 1;
            outputStr[outputIndex] = string;
        }
        return String.join(" ", outputStr);
    }
}
