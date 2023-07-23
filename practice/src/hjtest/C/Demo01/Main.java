package hjtest.C.Demo01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String inputStr = input.nextLine();
            int[] ints = getInts(inputStr);
            List<Point> listPoint = listPoint(ints);
            int a = getA(listPoint);
            int b = getB(listPoint);
            int c = getC(listPoint);
            System.out.println(a + b - c);
        }
        input.close();
    }

    private static int getC(List<Point> listPoint) {
        int[] xList = listPoint.stream().mapToInt(Point::getX).sorted().toArray();
        int[] yList = listPoint.stream().mapToInt(Point::getY).sorted().toArray();
        int x1 = xList[1];
        int y1 = yList[1];
        int x2 = xList[2];
        int y2 = yList[2];
        return Math.abs(x1 - x2) * Math.abs(y1 - y2);
    }

    private static int getB(List<Point> listPoint) {
        Point b1 = listPoint.get(2);
        Point b2 = listPoint.get(3);
        int len = Math.abs(b1.x - b2.x);
        int height = Math.abs(b1.y - b2.y);
        return len * height;
    }

    private static int getA(List<Point> listPoint) {
        Point a1 = listPoint.get(0);
        Point a2 = listPoint.get(1);
        int len = Math.abs(a1.x - a2.x);
        int height = Math.abs(a1.y - a2.y);
        return len * height;
    }

    private static List<Point> listPoint(int[] ints) {
        int xIndex = 0;
        int yIndex = 1;
        int len = ints.length;
        List<Point> listPoint = new ArrayList<>();
        while (xIndex < len && yIndex < len) {
            int x = ints[xIndex];
            int y = ints[yIndex];
            Point point = new Point(x,y);
            listPoint.add(point);
            xIndex+=2;
            yIndex+=2;
        }
        return listPoint;
    }

    private static int[] getInts(String inputStr) {
        String[] splits = inputStr.split(", ");
        int[] ints = new int[splits.length];
        for (int i = 0; i < splits.length; i++) {
            ints[i] = getInt(splits[i]);
        }
        return ints;
    }

    private static int getInt(String split) {
        int index = split.indexOf("=") + 1;
        return Integer.parseInt(split.substring(index));
    }

    private static class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
