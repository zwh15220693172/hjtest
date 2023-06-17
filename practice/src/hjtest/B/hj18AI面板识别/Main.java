package hjtest.B.hj18AI面板识别;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int count = Integer.parseInt(input.nextLine());
            List<Light> listLight = listLight(count, input);
            String result = listLight.stream().sorted(new Comparator<Light>() {
                @Override
                public int compare(Light a, Light b) {
                    if (a.y == b.y) {
                        return a.x - b.x;
                    }
                    return a.y - b.y;
                }
            }).map(Light::toString).collect(Collectors.joining(" "));
            System.out.println(result);
        }
        input.close();
    }

    private static List<Light> listLight(int count, Scanner input) {
        List<Light> listLight = new ArrayList<>();
        while (count > 0) {
            String[] strings = input.nextLine().split(" ");
            int code = Integer.parseInt(strings[0]);
            int x = Integer.parseInt(strings[1]);
            int y = Integer.parseInt(strings[2]);
            listLight.add(new Light(x,y,code));
            count--;
        }
        return listLight;
    }

    private static class Light {
        private final int x;
        private final int y;
        private final int code;

        public Light(int x, int y, int code) {
            this.x = x;
            this.y = y;
            this.code = code;
        }

        @Override
        public String toString() {
            return String.valueOf(code);
        }
    }
}
