package hjtest.B复100分.hj19相对开音节字母;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 100%通过
 */
public class Main {
    private static final Pattern haveIllegal = Pattern.compile("[^a-z]");

    private static final Pattern reserve = Pattern.compile("e[^aeiour][aeiou][^aeiou]");

    private static final Pattern normal = Pattern.compile("[^aeiou][aeiou][^aeiour]e");

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String[] splits = input.nextLine().split(" ");
            int count = 0;
            for (String split : splits) {
                Pattern complete = getComplete(split);
                for (int i = 0; i <= split.length() - 4; i++) {
                    String substring = split.substring(i, i + 4);
                    Matcher illegal = haveIllegal.matcher(substring);
                    if (illegal.find()) {
                        continue;
                    }
                    Matcher matcher = complete.matcher(substring);
                    if (matcher.find()) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
        input.close();
    }

    private static Pattern getComplete(String split) {
        Matcher matcher = haveIllegal.matcher(split);
        if (matcher.find()) {
            return normal;
        } else {
            return reserve;
        }
    }
}
