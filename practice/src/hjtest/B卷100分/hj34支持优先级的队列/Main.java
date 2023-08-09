package hjtest.B卷100分.hj34支持优先级的队列;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 在生成listMessage元素集合的时候就做好去重工作
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            List<Message> listMessage = listMessage(input.nextLine());
            String collect = listMessage.stream().map(Message::toString)
                    .collect(Collectors.joining(","));
            System.out.println(collect);
        }
        input.close();
    }

    private static List<Message> listMessage(String nextLine) {
        String replace = nextLine.replaceAll("\\(", "").replaceAll("\\)", "");
        String[] splits = replace.split(",");
        int messageIndex = 0;
        int levelIndex = 1;
        int len = splits.length;
        int code = 1;
        List<Message> listMessage = new ArrayList<>();
        while (messageIndex < len && levelIndex < len) {
            int message = Integer.parseInt(splits[messageIndex]);
            int level = Integer.parseInt(splits[levelIndex]);
            Message curMessage = new Message(message,level);
            if (!listMessage.contains(curMessage)) {
                listMessage.add(curMessage);
                curMessage.setCode(code++);
            }
            messageIndex+=2;
            levelIndex+=2;
        }
        return listMessage.stream().sorted(new Comparator<Message>() {
            @Override
            public int compare(Message a, Message b) {
                if (a.level == b.level) {
                    return a.code - b.code;
                }
                return b.level - a.level;
            }
        }).collect(Collectors.toList());
    }

    private static class Message {
        private final int message;
        private final int level;

        private int code;

        public Message(int message, int level) {
            this.message = message;
            this.level = level;
        }

        public void setCode(int code) {
            this.code = code;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Message)) {
                return false;
            }
            Message other = (Message) obj;
            return this.message == other.message
                    && this.level == other.level;
        }

        @Override
        public String toString() {
            return String.valueOf(message);
        }
    }
}
