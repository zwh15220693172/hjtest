package hjtest.B复100分.hj95数大雁;

import java.util.*;

/**
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList<Integer> qIndexList = new LinkedList<>();
        List<int[]> quackInts = new ArrayList<>();
        int[] quackCount = new int[5];
        char[] chars = input.nextLine().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char cur = chars[i];
            if (cur == 'q') {
                qIndexList.addLast(i);
                quackCount[0]++;
            } else if (cur =='u') {
                if (quackCount[0] > quackCount[1]) {
                    quackCount[1]++;
                }
            } else if (cur == 'a') {
                if (quackCount[1] > quackCount[2]) {
                    quackCount[2]++;
                }
            } else if (cur == 'c') {
                if (quackCount[2] > quackCount[3]) {
                    quackCount[3]++;
                }
            } else {
                if (quackCount[3] > quackCount[4]) {
                    quackCount[4]++;
                    int qIndex = qIndexList.pop();
                    quackInts.add(new int[]{qIndex, i});
                }
            }
        }
        if (quackInts.isEmpty()) {
            System.out.println(-1);
        } else {
            int max = 1;
            for (int i = 0; i < quackInts.size(); i++) {
                int count = 1;
                int right = quackInts.get(i)[1];
                for (int j = i + 1; j < quackInts.size(); j++) {
                    int left = quackInts.get(j)[0];
                    if (left < right) {
                        count++;
                    }
                }
                max = Math.max(count,max);
            }
            System.out.println(max);
        }
    }
}
