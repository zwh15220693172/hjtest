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
            int result = -1;
            LinkedList<String> cursor = new LinkedList<>(target);
            int index = 0;
            boolean startMatching = false;
            while (index < sources.length) {
                String cur = sources[index];
                if (startMatching) {
                    if (cursor.remove(cur)) {
                        count++;
                        if (count == len) {
                            result = index - len + 1;
                            break;
                        }
                        index++;
                    } else {
                        startMatching = false;
                        count = 0;
                        cursor = new LinkedList<>(target);
                    }
                } else {
                    if (cursor.remove(cur)) {
                        startMatching = true;
                        count++;
                        if (count == len) {
                            result = index - len + 1;
                            break;
                        }
                    }
                    index++;
                }
            }
            System.out.println(result);
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
