package hjtest.B复100分.hj13按照单词下标区间翻转文章内容;

import java.util.Scanner;

/**
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String[] array = input.nextLine().split(" ");
            int start = getStart(input.nextLine());
            int end = getEnd(input.nextLine(), array);
            while (start < end) {
                String temp = array[end];
                array[end] = array[start];
                array[start] = temp;
                start++;
                end--;
            }
            System.out.println(String.join(" ", array));
        }
        input.close();
    }

    private static int getEnd(String nextLine, String[] array) {
        int end = Integer.parseInt(nextLine);
        if (end >= array.length) {
            return array.length - 1;
        }
        return end;
    }

    private static int getStart(String nextLine) {
        int start = Integer.parseInt(nextLine);
        if (start < 0) {
            return 0;
        }
        return start;
    }
}
