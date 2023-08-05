package hjtest.B.hj63字符匹配;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String[] sources = getSource(input.nextLine());
            String regex = input.nextLine();
            Pattern compile = Pattern.compile(regex);
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < sources.length; i++) {
                String cur = sources[i];
                Matcher matcher = compile.matcher(cur);
                if (matcher.find()) {
                    result.add(i);
                }
            }
            String collect = result.stream().map(String::valueOf).collect(Collectors.joining(","));
            System.out.println(collect);
        }
        input.close();
    }

    private static String[] getSource(String nextLine) {
        return nextLine.split(" ");
    }
}
