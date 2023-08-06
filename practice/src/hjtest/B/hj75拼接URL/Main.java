package hjtest.B.hj75拼接URL;

import java.util.Scanner;

// 把,全部变成/然后///变成一个/
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String target = input.nextLine();
            String replace = target.replaceAll(",", "/");
            StringBuilder result = new StringBuilder();
            char[] chars = replace.toCharArray();
            char pre = ' ';
            for (char aChar : chars) {
                if (aChar == '/' && pre == '/') {
                    continue;
                }
                result.append(aChar);
                pre = aChar;
            }
            System.out.println(result.toString());
        }
        input.close();
    }
}
