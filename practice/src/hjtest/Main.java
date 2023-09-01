package hjtest;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Pattern compile = Pattern.compile("^(01)+0$");
        while (input.hasNextLine()) {
            String line = input.nextLine() + "00";
            String[] chars = line.split("");
            String result = "";
            Stack<String> cursor = new Stack<>();
            for (String cur : chars) {
                if (!cursor.isEmpty() && cursor.peek().equals("0") && cur.equals("0")) {
                    String join = String.join("", cursor);
                    Matcher matcher = compile.matcher(join);
                    if (matcher.matches() && join.length() > result.length()) {
                        result = join;
                    }
                    cursor.clear();
                }
                cursor.push(cur);
            }
            if (result.isEmpty()) {
                System.out.println(-1);
            } else {
                System.out.println(result);
            }
        }
        input.close();
    }
}
