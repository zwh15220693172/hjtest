package hjtest.A.hj7不含101的数;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    private static final String target = "101";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            List<Integer> params = getParams(input.nextLine());
            int start = params.get(0);
            int end = params.get(1);
            List<String> listStr = listStr(start, end);
            int count = 0;
            for (String str : listStr) {
                if (!str.contains(target)) {
                    count++;
                }
            }
            System.out.println(count);
        }
        input.close();
    }

    private static List<String> listStr(int start, int end) {
        return IntStream.rangeClosed(start,end).mapToObj(Main::getStr).collect(Collectors.toList());
    }

    private static String getStr(int num) {
        String result = "";
        while (num > 0) {
            result = num % 2 + result;
            num /= 2;
        }
        return result;
    }

    private static List<Integer> getParams(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
    }
}
