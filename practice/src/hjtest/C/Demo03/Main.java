package hjtest.C.Demo03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int total = Integer.parseInt(input.nextLine());
            String result = getResult(total);
            System.out.println(result);
        }
        input.close();
    }

    private static String getResult(int total) {
        double result;
        if (total > 400) {
            result =  getMoreThan400(total);
        } else if (total > 150) {
            result = getMoreThan150(total);
        } else {
            result = getLessThan150(total);
        }
        return String.format("%.1f",result);
    }

    private static double getLessThan150(int total) {
        return 0.4463 * total;
    }

    private static double getMoreThan150(int total) {
        return 150 * 0.4463 + (total - 150) * 0.4663;
    }

    private static double getMoreThan400(int total) {
        return 150 * 0.4463 + 250 * 0.4663 + (total - 400) * 0.5663;
    }
}
