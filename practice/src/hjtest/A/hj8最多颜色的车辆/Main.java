package hjtest.A.hj8最多颜色的车辆;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] ints = getInts(input.nextLine());
            int k = Integer.parseInt(input.nextLine());
            Car car = new Car(ints,k);
            for (int i = k; i < ints.length; i++) {
                car.add(ints[i]);
                car.remove(ints[i-k]);
                car.calMax();
            }
            System.out.println(car.getMax());
        }
        input.close();
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static class Car {
        private final int[] cars = new int[3];
        private int max;

        public Car(int[] ints, int k) {
            for (int i = 0; i < k; i++) {
                cars[ints[i]]++;
            }
            calMax();
        }

        public void add(int index) {
            cars[index]++;
        }

        public void remove(int index) {
            cars[index]--;
        }

        public void calMax() {
            int cur = Math.max(Math.max(cars[0],cars[1]),cars[2]);
            max = Math.max(cur, max);
        }

        public int getMax() {
            return max;
        }
    }
}
