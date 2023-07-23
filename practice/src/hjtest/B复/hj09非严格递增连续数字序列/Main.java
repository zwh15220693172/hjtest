package hjtest.B复.hj09非严格递增连续数字序列;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String[] sources = input.nextLine().split("");
            Stack<Integer> cursor = new Stack<>();
            int max = Integer.MIN_VALUE;
            for (String source : sources) {
                if (Character.isLetter(source.charAt(0))) {
                    cursor.clear();
                } else if (Character.isDigit(source.charAt(0))) {
                    int cur = Integer.parseInt(source);
                    if (!cursor.isEmpty() && cur < cursor.peek()) {
                        cursor.clear();
                    }
                    cursor.push(cur);
                    max = Math.max(cursor.size(),max);
                }
            }
            System.out.println(max);
        }
        input.close();
    }
}
