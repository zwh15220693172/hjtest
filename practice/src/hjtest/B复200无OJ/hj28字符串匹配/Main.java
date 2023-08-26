package hjtest.B复200无OJ.hj28字符串匹配;

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
            String[] strings = input.nextLine().split(" ");
            String regex = input.nextLine();
            Pattern compile = Pattern.compile(regex);
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < strings.length; i++) {
                String cur = strings[i];
                Matcher matcher = compile.matcher(cur);
                if (matcher.matches()) {
                    result.add(i);
                }
            }
            if (result.isEmpty()) {
                System.out.println(-1);
            } else {
                String collect = result.stream().map(String::valueOf).collect(Collectors.joining(","));
                System.out.println(collect);
            }
        }
    }
}
