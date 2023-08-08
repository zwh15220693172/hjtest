package hjtest.B卷100分.hj03AI识别面板;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 100%通过
 * 没啥好说的，x1,y1就能解决问题，按照x1,y1最小排序
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int count = Integer.parseInt(input.nextLine());
            List<Point> listPoint = listPoint(count,input);
            String result = listPoint.stream().map(Point::getId).map(String::valueOf)
                    .collect(Collectors.joining(" "));
            System.out.println(result);
        }
        input.close();
    }

    private static List<Point> listPoint(int count, Scanner input) {
        List<Point> listPoint = new ArrayList<>();
        while (count > 0) {
            String line = input.nextLine();
            String[] splits = line.split(" ");
            int id = Integer.parseInt(splits[0]);
            int x1 = Integer.parseInt(splits[1]);
            int y1 = Integer.parseInt(splits[2]);
            int x2 = Integer.parseInt(splits[3]);
            int y2 = Integer.parseInt(splits[4]);
            Point point = new Point(id,x1,y1,x2,y2);
            listPoint.add(point);
            count--;
        }
        return listPoint.stream().sorted(new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b) {
                if (a.y1 == b.y1) {
                    return a.x1 - b.x1;
                }
                return a.y1 - b.y1;
            }
        }).collect(Collectors.toList());
    }

    private static class Point {
        private final int id;
        private final int x1;
        private final int y1;
        private final int x2;
        private final int y2;

        private final int radius;

        public Point(int id, int x1, int y1, int x2, int y2) {
            this.id = id;
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.radius = y2 - y1;
        }

        public int getId() {
            return id;
        }

        public int getX1() {
            return x1;
        }

        public int getY1() {
            return y1;
        }

        public int getX2() {
            return x2;
        }

        public int getY2() {
            return y2;
        }

        @Override
        public String toString() {
            return String.valueOf(id);
        }
    }
}
