package hjtest.B复200分.hj08文本统计分析;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringBuilder textBuilder = new StringBuilder();
        while (input.hasNextLine()) {
            String cur = input.nextLine();
            if (cur.isEmpty()) {
                break;
            }
            cur = removeLine(cur);
            cur = danYinHaoContainRemove(cur);
            cur = maoHaoContainRemove(cur);
            textBuilder.append(cur);
        }
        String text = textBuilder.toString();
        while (text.charAt(text.length()-1) == ';') {
            text = text.substring(0,text.length()-1);
        }
        int count = 0;
        String[] split = text.split(";");
        for (String cur : split) {
            if (!cur.isEmpty()) {
                count++;
            }
        }
        System.out.println(count);
        input.close();
    }

    private static String removeLine(String base) {
        int end = base.indexOf("-");
        if (end == -1) {
            return base;
        }
        return base.substring(0,end);
    }

    private static String danYinHaoContainRemove(String base) {
        base = base.replaceAll("\\\\[\"']","");
        char[] chars = base.toCharArray();
        StringBuilder result = new StringBuilder();
        boolean startAdd = true;
        for (char aChar : chars) {
            if (aChar == '\'') {
                startAdd = !startAdd;
                continue;
            }
            if (startAdd) {
                result.append(aChar);
            }
        }
        return result.toString();
    }

    private static String maoHaoContainRemove(String base) {
        base = base.replaceAll("\\\\[\"']","");
        char[] chars = base.toCharArray();
        StringBuilder result = new StringBuilder();
        boolean startAdd = true;
        for (char aChar : chars) {
            if (aChar == '"') {
                startAdd = !startAdd;
                continue;
            }
            if (startAdd) {
                result.append(aChar);
            }
        }
        return result.toString();
    }
}
