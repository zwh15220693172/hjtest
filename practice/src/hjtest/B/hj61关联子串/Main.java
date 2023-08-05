package hjtest.B.hj61关联子串;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String[] params = getParams(input.nextLine());
            List<String> target = listTarget(params[0]);
            int len = target.size();
            String[] sources = params[1].split("");
            int count = 0;
            int index = -1;
            LinkedList<String> cursor = new LinkedList<>(target);
            for (int i = 0; i < sources.length; i++) {
                String cur = sources[i];
                if (cursor.remove(cur)) {
                    count++;
                    if (count == len) {
                        index = i - len + 1;
                        break;
                    }
                } else {
                    count = 0;
                    cursor = new LinkedList<>(target);
                }
            }
            System.out.println(index);
        }
        input.close();
    }

    private static List<String> listTarget(String param) {
        return Arrays.stream(param.split(""))
                .collect(Collectors.toList());
    }

    private static String[] getParams(String nextLine) {
        return nextLine.split(" ");
    }
}
