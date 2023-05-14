package hjtest.hj02;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String weightAndCountStr = input.nextLine();
            int weight = getWeight(weightAndCountStr);
            int count = getCount(weightAndCountStr);
            int[] weights = getWeights(count, input.nextLine());
            Arrays.sort(weights);
            int left = 0;
            int right = weights.length - 1;
            int num = 0;
            while (left <= right) {
                if (weights[left] + weights[right] <= weight) {
                    left++;
                }
                num++;
                right--;
            }
            System.out.println(num);
        }
        input.close();
    }

    private static int[] getWeights(int count, String nextLine) {
        String[] splits = nextLine.split(" ");
        int[] weights = new int[count];
        for (int i = 0; i < splits.length; i++) {
            weights[i] = Integer.parseInt(splits[i]);
        }
        return weights;
    }

    private static int getCount(String weightAndCountStr) {
        String[] splits = weightAndCountStr.split(" ");
        return Integer.parseInt(splits[1]);
    }

    private static int getWeight(String weightAndCountStr) {
        String[] splits = weightAndCountStr.split(" ");
        return Integer.parseInt(splits[0]);
    }

}
