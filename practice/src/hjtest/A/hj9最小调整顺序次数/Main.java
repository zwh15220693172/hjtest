package hjtest.A.hj9最小调整顺序次数;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int count = Integer.parseInt(input.nextLine());
            List<String> commands = listCommand(count, input);
            LinkedList<Integer> elements = new LinkedList<>();
            int start = 1;
            int result = 0;
            for (String command : commands) {
                if (command.equals("remove")) {
                    if (!elements.isEmpty() && elements.peek() != start) {
                        Collections.sort(elements);
                        result++;
                    }
                    start++;
                    elements.pop();
                } else {
                    String[] splits = command.split(" ");
                    int number = Integer.parseInt(splits[2]);
                    if (command.contains("head")) {
                        elements.addFirst(number);
                    } else {
                        elements.addLast(number);
                    }
                }
            }
            System.out.println(result);
        }
        input.close();
    }

    private static List<String> listCommand(int count, Scanner input) {
        int time = count * 2;
        List<String> commands = new ArrayList<>();
        while (time > 0) {
            commands.add(input.nextLine());
            time--;
        }
        return commands;
    }
}
