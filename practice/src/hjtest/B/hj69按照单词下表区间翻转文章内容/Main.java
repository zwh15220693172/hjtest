package hjtest.B.hj69按照单词下表区间翻转文章内容;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String[] sources = input.nextLine().split(" ");
            int len = sources.length;
            int start = getStart(input.nextLine(),len);
            int end = getEnd(input.nextLine(),len);
            while (start < end) {
                String temp = sources[end];
                sources[end] = sources[start];
                sources[start] = temp;
                start++;
                end--;
            }
            String collect = String.join(" ", sources);
            System.out.println(collect);
        }
        input.close();
    }

    private static int getEnd(String nextLine, int len) {
        int end = Integer.parseInt(nextLine);
        if (end <= 0) {
            return 0;
        }
        if (end >= len) {
            return len - 1;
        }
        return end;
    }

    private static int getStart(String nextLine, int len) {
        int start = Integer.parseInt(nextLine);
        return Math.max(start, 0);
    }
}
