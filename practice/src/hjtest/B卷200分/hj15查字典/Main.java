package hjtest.B卷200分.hj15查字典;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 简单题目
 * indexOf
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String[] splits = input.nextLine().split(" ");
            String pre = splits[0];
            int len = Integer.parseInt(splits[1]);
            List<String> result = new ArrayList<>();
            for (int i = 2; i < 2 + len; i++) {
                String cur = splits[i];
                if (cur.startsWith(pre)) {
                    result.add(cur);
                }
            }
            if (result.isEmpty()) {
                System.out.println(-1);
            } else {
                result.forEach(System.out::println);
            }
        }
        input.close();
    }
}
