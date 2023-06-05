package hjtest.B.hj9食堂供餐;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int len = Integer.parseInt(input.nextLine());
            int base = Integer.parseInt(input.nextLine());
            int[] persons = getPersons(input.nextLine());
            int result = getResult(base, persons);
            System.out.println(result);
        }
        input.close();
    }

    private static int getResult(int base, int[] persons) {
        int min = 1;
        int max = Arrays.stream(persons).sum() - base;
        int result = 0;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (fit(mid, base, persons)) {
                result = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return result;
    }

    private static boolean fit(int mid, int base, int[] persons) {
        for (int person : persons) {
            if (base < person) {
                return false;
            }
            base = base + mid - person;
        }
        return true;
    }

    private static int[] getPersons(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
