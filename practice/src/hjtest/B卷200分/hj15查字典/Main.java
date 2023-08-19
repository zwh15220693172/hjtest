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
        String pre = input.next();
        int len = input.nextInt();
        boolean getResult = false;
        for (int i = 0; i < len; i++) {
            String cur = input.next();
            if (cur.startsWith(pre)) {
                System.out.println(cur);
                getResult = true;
            }
        }
        if (!getResult) {
            System.out.println(-1);
        }
        input.close();
    }
}
