package hjtest.B复100分.hj17拼接URL;


import java.util.Scanner;

/**
 * 一个没过，不一定是对的
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String inputStr = input.nextLine();
            String replace = inputStr.replaceAll(",", "/");
            char[] chars = replace.toCharArray();
            char pre = ' ';
            StringBuilder result = new StringBuilder();
            for (char aChar : chars) {
                if (aChar == '/' && pre == '/') {
                    continue;
                }
                result.append(aChar);
                pre = aChar;
            }
            String collect = result.toString();
            if (collect.startsWith("https:/")) {
                collect = collect.replaceAll("https:/","https://");
            } else if (collect.startsWith("http:/")) {
                collect = collect.replaceAll("http:/","https://");
            }
            System.out.println(collect);
        }
        input.close();
    }
}
