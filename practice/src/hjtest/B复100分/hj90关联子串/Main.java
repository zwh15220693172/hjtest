package hjtest.B复100分.hj90关联子串;

import java.util.Scanner;

/**
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String[] params = input.nextLine().split(" ");
            int len = params[0].length();
            int[] target = getTarget(params[0]);
            int[] cursor = buildCursor(target);
            char[] source = params[1].toCharArray();
            int count = 0;
            int result = -1;
            int index = 0;
            while (index < source.length) {
                char cur = source[index];
                if (cursor[cur] == 0) {
                    if (count > 0) {
                        index = index - count + 1;
                        cursor = buildCursor(target);
                        count = 0;
                    } else {
                        index++;
                    }
                } else {
                    cursor[cur]--;
                    count++;
                    if (count == len) {
                        result = index - len + 1;
                        break;
                    }
                    index++;
                }
            }
            System.out.println(result);
        }
        input.close();
    }

    private static int[] buildCursor(int[] target) {
        int[] cursor = new int[target.length];
        System.arraycopy(target,0,cursor,0,target.length);
        return cursor;
    }

    private static int[] getTarget(String param) {
        int[] target = new int[128];
        char[] chars = param.toCharArray();
        for (char cur : chars) {
            target[cur]++;
        }
        return target;
    }
}
