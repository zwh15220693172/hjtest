package hjtest.B.hj49评论转换输出;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static int MAX_LEVEL;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            MAX_LEVEL = Integer.MIN_VALUE;
            List<Message> listMessage = listMessage(input.nextLine());
            int len = listMessage.size();
            boolean[] used = new boolean[len];
            for (int i = 0; i < len; i++) {
                setLevel(i,1,len,used,listMessage);
            }
            System.out.println(MAX_LEVEL);
            Map<Integer, List<Message>> map = listMessage.stream().collect(Collectors.groupingBy(Message::getLevel));
            map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach((entry)->{
                String collect = entry.getValue().stream().map(Message::getMessageStr)
                        .collect(Collectors.joining(" "));
                System.out.println(collect);
            });
        }
        input.close();
    }

    private static boolean setLevel(int index, int level, int len, boolean[] used, List<Message> listMessage) {
        Message cur = listMessage.get(index);
        if (cur.level != 0) {
            return false;
        }
        cur.level = level;
        MAX_LEVEL = Math.max(level, MAX_LEVEL);
        used[index] = true;
        if (cur.child == 0) {
            return true;
        }
        int count = cur.child;
        while (count > 0) {
            for (int i = index + 1; i < len; i++) {
                if (setLevel(i,level+1,len,used,listMessage)) {
                    count--;
                    if (count == 0) {
                        break;
                    }
                }
            }
        }
        return true;
    }

    private static List<Message> listMessage(String nextLine) {
        String[] splits = nextLine.split(",");
        int len = splits.length;
        List<Message> listMessage = new ArrayList<>();
        int messageIndex = 0;
        int childIndex = 1;
        while (messageIndex < len && childIndex < len) {
            String messageStr = splits[messageIndex];
            int child = Integer.parseInt(splits[childIndex]);
            messageIndex+=2;
            childIndex+=2;
            listMessage.add(new Message(messageStr,child));
        }
        return listMessage;
    }

    private static class Message {
        private final String messageStr;
        private final int child;

        private int level;

        public Message(String messageStr, int child) {
            this.messageStr = messageStr;
            this.child = child;
        }

        public int getLevel() {
            return level;
        }

        public String getMessageStr() {
            return messageStr;
        }
    }
}
