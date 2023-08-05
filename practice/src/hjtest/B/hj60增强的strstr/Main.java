package hjtest.B.hj60增强的strstr;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String source = input.nextLine();
            String regex = input.nextLine();
            Pattern compile = Pattern.compile(regex);
            Matcher matcher = compile.matcher(source);
            if (matcher.find()) {
                System.out.println(matcher.start());
            }
        }
        input.close();
    }
}
