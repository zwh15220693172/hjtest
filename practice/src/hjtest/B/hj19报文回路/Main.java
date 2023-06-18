package hjtest.B.hj19报文回路;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int count = Integer.parseInt(input.nextLine());
            List<String> commands = listCommand(count, input);
            String result = getResult(commands);
            System.out.println(result);
        }
        input.close();
    }

    private static String getResult(List<String> commands) {
        for (String command : commands) {
            String[] strings = command.split(" ");
            String review = strings[1] + " " + strings[0];
            if (!commands.contains(review)) {
                return "False";
            }
        }
        return "True";
    }

    private static List<String> listCommand(int count, Scanner input) {
        List<String> commands = new ArrayList<>();
        while (count > 0) {
            commands.add(input.nextLine());
            count--;
        }
        return commands;
    }
}
