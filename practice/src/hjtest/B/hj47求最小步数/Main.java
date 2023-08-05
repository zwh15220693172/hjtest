package hjtest.B.hj47求最小步数;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int count = Integer.parseInt(input.nextLine());
            if (count == 1) {
                System.out.println(2);
            } else if (count == 2 || count == 3) {
                System.out.println(1);
            } else {
                if (count % 3 == 0) {
                    System.out.println(count / 3);
                } else {
                    System.out.println(count / 3 + 1);
                }
            }
        }
        input.close();
    }
}
