package hjtest.A.hj12完美走位;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            char[] chars = input.nextLine().toCharArray();
            int count = 0;
            for (int i = 0; i < chars.length; i++) {
                int index = i % 4;
                char cur = chars[i];
                if (index == 0) {
                    if (cur != 'W') {
                        count++;
                    }
                } else if (index == 1) {
                    if (cur != 'A') {
                        count++;
                    }
                } else if (index == 2) {
                    if (cur != 'S') {
                        count++;
                    }
                } else {
                    if (cur != 'D') {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
        input.close();
    }
}
