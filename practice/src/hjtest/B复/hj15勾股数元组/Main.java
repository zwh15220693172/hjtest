package hjtest.B复.hj15勾股数元组;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int start = Integer.parseInt(input.nextLine());
            int end = Integer.parseInt(input.nextLine());
            for (int i = start; i <= end; i++) {
                for (int j = i + 1; j <= end; j++) {
                    for (int k = j + 1; k <= end; k++) {
                        if (noZhi(i,j) && noZhi(j,k) && noZhi(i,k) && isGouGu(i,j,k)) {
                            System.out.println(i + " " + j + " " + k);
                        }
                    }
                }
            }
        }
        input.close();
    }

    private static boolean isGouGu(int i, int j, int k) {
        return i * i + j * j == k * k;
    }

    private static boolean noZhi(int i, int j) {
        int len = Math.min(i,j);
        for (int cur = 2; cur < len; cur++) {
            if ((i % cur == 0) && (j % cur == 0)) {
                return false;
            }
        }
        return true;
    }
}
