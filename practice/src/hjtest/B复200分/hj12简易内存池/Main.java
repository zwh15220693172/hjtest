package hjtest.B复200分.hj12简易内存池;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final List<String> outputList = new ArrayList<>();
    private static final HashMap<Integer,Integer> idSize = new HashMap<>();
    private static boolean[] used;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            used = new boolean[101];
            outputList.clear();
            idSize.clear();
            int count = Integer.parseInt(input.nextLine());
            List<String> commands = listCommand(count, input);
            commands.forEach(Main::detailCommand);
            outputList.forEach(System.out::println);
        }
        input.close();
    }

    private static void detailCommand(String command) {
        int digit = getDigit(command);
        if (command.contains("REQUEST")) {
            request(digit);
        } else {
            release(digit);
        }
    }

    private static void release(int id) {
        if (!idSize.containsKey(id)) {
            outputList.add("error");
        } else {
            int size = idSize.remove(id);
            for (int i = id; i < id + size; i++) {
                used[i] = false;
            }
        }
    }

    private static void request(int size) {
        int count = 0;
        int id = -1;
        for (int i = 0; i < used.length; i++) {
            if (!used[i]) {
                count++;
                if (count == size) {
                    id = i - count + 1;
                    break;
                }
            } else {
                count = 0;
            }
        }
        if (id == -1) {
            outputList.add("error");
        } else {
            for (int i = id; i < id + size; i++) {
                used[i] = true;
            }
            idSize.put(id,size);
            outputList.add(String.valueOf(id));
        }
    }

    private static int getDigit(String command) {
        StringBuilder digitBuilder = new StringBuilder();
        char[] chars = command.toCharArray();
        for (int i = chars.length - 1; i > 0; i--) {
            char cur = chars[i];
            if (Character.isDigit(cur)) {
                digitBuilder.insert(0,cur);
            }
        }
        return Integer.parseInt(digitBuilder.toString());
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
