package hjtest.B.hj14告警抑制;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int count = Integer.parseInt(input.nextLine());
            String[] commands = getCommands(count,input);
            String targetStr = input.nextLine();
            String result = getResult(commands,targetStr);
            System.out.println(result);
        }
        input.close();
    }

    private static String getResult(String[] commands, String targetStr) {
        String[] strings = targetStr.split(" ");
        HashSet<String> containSet = new HashSet<>(Arrays.asList(strings));
        for (String command : commands) {
            String[] splits = command.split(" ");
            String aliveStr = splits[0];
            String removeStr = splits[1];
            if (containSet.contains(aliveStr) && containSet.contains(removeStr)) {
                for (int i = 0; i < strings.length; i++) {
                    if (removeStr.equals(strings[i])) {
                        strings[i] = null;
                    }
                }
            }
        }
        return Arrays.stream(strings).filter(Objects::nonNull).collect(Collectors.joining(" "));
    }

    private static String[] getCommands(int count, Scanner input) {
        String[] commands = new String[count];
        int index = 0;
        while (count > 0) {
            commands[index++] = input.nextLine();
            count--;
        }
        return commands;
    }
}
