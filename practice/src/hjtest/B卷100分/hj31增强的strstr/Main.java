package hjtest.B卷100分.hj31增强的strstr;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 考察的是java里面的正则表达式
 * 别忘了，如果没有找到数据，那么要返回-1
 * 100%通过
 */
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
            } else {
                System.out.println(-1);
            }
        }
        input.close();
    }
}
