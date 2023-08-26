package hjtest.B复200分.hj53出错的或电路;

import java.util.Scanner;

/**
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int len = Integer.parseInt(input.nextLine());
            char[] chars01 = input.nextLine().toCharArray();
            char[] chars02 = input.nextLine().toCharArray();
            long x = 0;
            long y = 0;
            long a = 0;
            long b = 0;
            for (int i = 0; i < len; i++) {
                char char02 = chars02[i];
                char char01 = chars01[i];
                if (char02 == '0') {
                    if (char01 == '0') {
                        x++;
                    } else {
                        y++;
                    }
                }
                if (char01 == '1') {
                    a++;
                } else {
                    b++;
                }
            }
            long result = x * a + y * b - x * y;
            System.out.println(result);
        }
    }
}
