package hjtest.B卷100分.hj18报文响应时间;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 100%通过
 * 注意：0x10是16进制的意思
 * 1.小于128直接返回
 * 2.大于128使用Integer.toBinaryString(number)
 * 3.用一个stringbuilder将上面的结果包裹
 * 4.如果不足8位，使用0进行补位
 * 5.Integer.parseInt(substring(1,4),2)为exp
 * 6.Integer.parseInt(substring(4),2)为mant
 * 7.公式为（mant | 16 ）<< (exp + 3)
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int len = Integer.parseInt(input.nextLine());
            List<String> command = listCommand(len, input);
            int min = Integer.MAX_VALUE;
            for (String com : command) {
                int time = getTime(com);
                min = Math.min(time, min);
            }
            System.out.println(min);
        }
        input.close();
    }

    private static int getTime(String com) {
        String[] splits = com.split(" ");
        int startTime = Integer.parseInt(splits[0]);
        int maxRespTime = getMaxRespTime(splits[1]);
        return startTime + maxRespTime;
    }

    private static int getMaxRespTime(String split) {
        int respTime = Integer.parseInt(split);
        if (respTime < 128) {
            return respTime;
        }
        String binaryString = Integer.toBinaryString(respTime);
        StringBuilder stringBuilder = new StringBuilder(binaryString);
        if (stringBuilder.length() < 8) {
            stringBuilder.insert(0,'0');
        }
        int exp = Integer.parseInt(stringBuilder.substring(1, 4), 2);
        int mant = Integer.parseInt(stringBuilder.substring(4,8),2);
        return (mant | 16) << (exp + 3);
    }

    private static List<String> listCommand(int len, Scanner input) {
        List<String> listCommand = new ArrayList<>();
        while (len > 0) {
            listCommand.add(input.nextLine());
            len--;
        }
        return listCommand;
    }
}
