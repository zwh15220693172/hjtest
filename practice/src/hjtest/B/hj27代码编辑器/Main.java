package hjtest.B.hj27代码编辑器;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static int index;
    private static String inputStr;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            index = 0;
            int count = Integer.parseInt(input.nextLine());
            inputStr = input.nextLine();
            List<String> commands = listCommand(count, input);
            commands.forEach(Main::detailCommand);
            System.out.println(inputStr);
        }
        input.close();
    }

    private static void detailCommand(String command) {
        if (command.startsWith("FORWARD")) {
            forward(command);
        }
        if (command.startsWith("BACKWARD")) {
            backward(command);
        }
        if (command.startsWith("SEARCH-FORWARD")) {
            searchForward(command);
        }
        if (command.startsWith("SEARCH-BACKWARD")) {
            searchBackward(command);
        }
        if (command.startsWith("REPLACE")) {
            replace(command);
        }
        if (command.startsWith("DELETE")) {
            delete(command);
        }
        if (command.startsWith("INSERT")) {
            insert(command);
        }
    }

    private static void delete(String command) {
        int number = getNumber(command);
        if (atFirst()) {
            if (index + number >= inputStr.length()) {
                index = 0;
            } else {
                inputStr = inputStr.substring(index+number);
            }
        } else if (atMedium()) {
            if (index + number >= inputStr.length()) {
                inputStr = inputStr.substring(0,index);
            } else {
                String part1 = inputStr.substring(0, index);
                String part2 = inputStr.substring(index + number);
                inputStr = part1 + part2;
            }
        }
    }

    private static void replace(String command) {
        String word = getWord(command);
        int len = word.length();
        if (atFirst()) {
            if (len >= inputStr.length()) {
                inputStr = word;
            } else {
                String last = inputStr.substring(len);
                inputStr = word + last;
            }
        } else if (atEnd()) {
            addLast(word);
        } else {
            if (index + len >= inputStr.length()) {
                String first = inputStr.substring(0,index);
                inputStr = first + word;
            } else {
                String part1 = inputStr.substring(0, index);
                String part2 = inputStr.substring(index + len);
                inputStr = part1 + word + part2;
            }
        }
    }

    private static void insert(String command) {
        String word = getWord(command);
        if (atFirst()) {
            addFirst(word);
        } else if (atEnd()) {
            addLast(word);
        } else {
            String part1 = inputStr.substring(0, index);
            String part2 = inputStr.substring(index);
            inputStr = part1 + word + part2;
        }
        index = inputStr.length();
    }

    private static void searchBackward(String command) {
        String word = getWord(command);
        int next = inputStr.indexOf(word);
        if (next >= 0 && next < index) {
            index = next;
        }
    }

    private static void searchForward(String command) {
        String word = getWord(command);
        int next = inputStr.indexOf(word);
        if (next > index) {
            index = next;
        }
    }

    private static void backward(String command) {
        int move = getNumber(command);
        if (index - move < 0) {
            index = 0;
        } else {
            index -= move;
        }
    }

    private static void forward(String command) {
        int move = getNumber(command);
        if (index + move > inputStr.length())  {
            index = inputStr.length();
        } else {
            index += move;
        }
    }

    private static String getWord(String command) {
        int firstSpace = findFirstSpace(command);
        return command.substring(firstSpace+1);
    }

    private static int getNumber(String command) {
        String word = getWord(command);
        return Integer.parseInt(word);
    }

    private static int findFirstSpace(String command) {
        return command.indexOf(" ");
    }

    private static boolean atFirst() {
        return index == 0;
    }

    private static boolean atEnd() {
        return index == inputStr.length();
    }

    private static boolean atMedium() {
        return !atFirst() && !atEnd();
    }

    private static void addLast(String addStr) {
        inputStr += addStr;
    }

    private static void addFirst(String addStr) {
        inputStr = addStr + inputStr;
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
