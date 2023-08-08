package hjtest.B卷100分.hj04报文回路;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 注意，9 10翻转过来是10 9不是 01 9
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int count = Integer.parseInt(input.nextLine());
            List<String> listCommand = listCommand(count, input);
            System.out.println(getResult(listCommand));
        }
        input.close();
    }

    private static String getResult(List<String> listCommand) {
        for (String cur : listCommand) {
            String reserve = reserve(cur);
            if (!listCommand.contains(reserve)) {
               return "False";
            }
        }
        return "True";
    }

    private static String reserve(String cur) {
        String[] splits = cur.split(" ");
        return splits[1] + " " + splits[0];
    }

    private static List<String> listCommand(int count, Scanner input) {
        List<String> listCommand = new ArrayList<>();
        while (count > 0) {
            listCommand.add(input.nextLine());
            count--;
        }
        return listCommand;
    }
}
