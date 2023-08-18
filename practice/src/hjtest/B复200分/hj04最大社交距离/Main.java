package hjtest.B复200分.hj04最大社交距离;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int seatNum = Integer.parseInt(input.nextLine());
            int[] seatOrLeave = getInts(input.nextLine());
            LinkedList<Integer> result = new LinkedList<>();
            int ans = -1;
            for (int seat : seatOrLeave) {
                ans = -1;
                if (seat != 1) {
                    result.remove(new Integer(-seat));
                } else if (result.isEmpty()) {
                    ans = 0;
                    result.addFirst(ans);
                } else if (result.size() == 1) {
                    ans = seatNum - 1;
                    result.addLast(ans);
                } else {
                    int maxDis = -1;
                    int start = -1;
                    for (int i = 1; i < result.size(); i++) {
                        int curDis = (result.get(i) - result.get(i-1)) / 2;
                        if (curDis > maxDis) {
                            maxDis = curDis;
                            start = result.get(i-1);
                        }
                    }
                    int endDis = (seatNum - 1 - result.getLast()) / 2;
                    if (endDis > maxDis) {
                        maxDis = endDis;
                        start = result.getLast();
                    }
                    ans = maxDis + start;
                    result.add(ans);
                    Collections.sort(result);
                }
            }
            System.out.println(ans);
        }
        input.close();
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(","))
                .mapToInt(Integer::parseInt).toArray();
    }
}
