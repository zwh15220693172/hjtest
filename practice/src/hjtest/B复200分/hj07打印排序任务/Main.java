package hjtest.B复200分.hj07打印排序任务;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 100%通过，按照题目描述去写代码就可以了
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] ints = getInts(input.nextLine());
            LinkedList<Message> list = buildMessage(ints);
            LinkedList<Message> result = setCode(list);
            String collect = result.stream().sorted(new Comparator<Message>() {
                @Override
                public int compare(Message a, Message b) {
                    return a.index - b.index;
                }
            }).map(Message::getCode).collect(Collectors.joining(","));
            System.out.println(collect);
        }
        input.close();
    }

    private static LinkedList<Message> setCode(LinkedList<Message> list) {
        LinkedList<Message> result = new LinkedList<>();
        int code = 0;
        while (!list.isEmpty()) {
            int maxLevel = findMaxLevel(list);
            while (!list.isEmpty() && list.peek().level < maxLevel) {
                Message cur = list.pop();
                list.addLast(cur);
            }
            Message cur = list.pop();
            cur.code = code++;
            result.addLast(cur);
        }
        return result;
    }

    private static int findMaxLevel(LinkedList<Message> list) {
        return list.stream().map(Message::getLevel).mapToInt(Integer::intValue).max().getAsInt();
    }

    private static LinkedList<Message> buildMessage(int[] ints) {
        LinkedList<Message> list = new LinkedList<>();
        for (int i = 0; i < ints.length; i++) {
            Message message = new Message();
            message.index = i;
            message.level = ints[i];
            list.addLast(message);
        }
        return list;
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(","))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static class Message {
        private int index;
        private int level;
        private int code;

        public int getIndex() {
            return index;
        }

        public int getLevel() {
            return level;
        }

        public String getCode() {
            return String.valueOf(code);
        }
    }
}
