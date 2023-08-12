package hjtest.B卷200分.hj13数字游戏;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> resultList = new ArrayList<>();
        while (input.hasNextLine()) {
            String inputStr = input.nextLine();
            if (inputStr.isEmpty()) {
                break;
            }
            int[] lenMod = lenMod(inputStr);
            int len = lenMod[0];
            int mod = lenMod[1];
            int[] ints = getInts(input.nextLine());
            int[] result = new int[mod];
            result[0] = 1;
            int cur = 0;
            boolean getResult = false;
            for (int anInt : ints) {
                cur += anInt;
                cur %= mod;
                if (result[cur] == 1) {
                    getResult = true;
                    break;
                }  else {
                    result[cur] = 1;
                }
            }
            if (getResult) {
                resultList.add(1);
            } else {
                resultList.add(0);
            }
        }
        resultList.forEach(System.out::println);
        input.close();
    }

    private static int[] lenMod(String inputStr) {
        return getInts(inputStr);
    }

    private static int[] getInts(String inputStr) {
        return Arrays.stream(inputStr.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }
}
