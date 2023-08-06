package hjtest.B.hj72相对开音节;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final Pattern notContain = Pattern.compile("[^a-z]");

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String[] splits = input.nextLine().split(" ");
            int count = 0;
            for (String split : splits) {
                // 包含非小写字母的不反转
                Pattern compile = getCompile(split);
                int len = split.length();
                for (int i = 0; i <= len - 4; i++) {
                    String substring = split.substring(i, i + 4);
                    // [^aeiou], [^aeiour]也包含其他奇奇怪怪的字符
                    if (notContain.matcher(substring).find()) {
                        continue;
                    }
                    Matcher matcher = compile.matcher(substring);
                    if (matcher.find()) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
        input.close();
    }

    private static Pattern getCompile(String target) {
        Matcher matcher = notContain.matcher(target);
        if (matcher.find()) {
            return Pattern.compile("[^aeiou][aeiou][^aeiour]e");
        }
        return Pattern.compile("e[^aeiour][aeiou][^aeiou]");
    }
}
