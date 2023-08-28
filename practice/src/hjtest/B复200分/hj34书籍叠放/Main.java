package hjtest.B复200分.hj34书籍叠放;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 100通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String line = input.nextLine();
            String replace = line.replaceAll("\\[", "").replaceAll("]", "");
            int[][] books = getBooks(replace);
            int[] dp = new int[books.length];
            Arrays.fill(dp,1);
            Arrays.sort(books, new Comparator<int[]>() {
                @Override
                public int compare(int[] a, int[] b) {
                    return a[0] - b[0];
                }
            });
            if (books.length <= 1) {
                System.out.println(books.length);
            } else {
                int res = 1;
                for (int i = 1; i < books.length; i++) {
                    int[] cur = books[i];
                    for (int j = 0; j < i; j++) {
                        int[] last = books[j];
                        if (cur[0] > last[0] && cur[1] > last[1]) {
                            dp[i] = Math.max(dp[i],dp[j]+1);
                        }
                    }
                    res = Math.max(res,dp[i]);
                }
                System.out.println(res);
            }
        }
        input.close();
    }

    private static int[][] getBooks(String replace) {
        String[] splits = replace.split(",");
        int len = splits.length / 2;
        int[][] books = new int[len][];
        int index = 0;
        int widthIndex = 0;
        int heightIndex = 1;
        while (widthIndex < splits.length && heightIndex < splits.length) {
            int width = Integer.parseInt(splits[widthIndex]);
            int height = Integer.parseInt(splits[heightIndex]);
            books[index++] = new int[]{width,height};
            widthIndex+=2;
            heightIndex+=2;
        }
        return books;
    }
}
