package hjtest.租车骑绿岛;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine())  {
            List<Integer> listTotalAndPerson = listTotalAndPerson(input.nextLine());
            int total = listTotalAndPerson.get(0);
            int[] weights = weights(input.nextLine());
            int count = 0;
            int left = 0;
            int right = weights.length - 1;
            while (left <= right) {
                if (weights[left] + weights[right] <= total) {
                    left++;
                }
                count++;
                right--;
            }
            System.out.println(count);
        }
        input.close();
    }

    private static int[] weights(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).sorted().toArray();
    }

    private static List<Integer> listTotalAndPerson(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
