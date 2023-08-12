package hjtest.B卷100分.hj08模拟消息队列;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 100%通过
 * 同一个订阅时间，越晚出现的消费者，级别越高
 * 1.如果发布时间，大于等于退顶时间，那么无缘接受到消息
 * 2.如果比发布时间要小，那么取最接近的时间，最好是等于的
 * 3，如果有两个等于的时间，那么后面出现的消费者的等级更高
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            List<Message> listMessage = listMessage(input.nextLine());
            List<Consumer> listConsumer = listConsumer(input.nextLine());
            setMessage(listConsumer,listMessage);
            listConsumer.stream().sorted(new Comparator<Consumer>() {
                @Override
                public int compare(Consumer a, Consumer b) {
                    return a.code - b.code;
                }
            }).forEach(System.out::println);
        }
        input.close();
    }

    private static void setMessage(List<Consumer> listConsumer, List<Message> listMessage) {
        listConsumer.sort(new Comparator<Consumer>() {
            @Override
            public int compare(Consumer a, Consumer b) {
                if (a.start == b.start) {
                    return b.code - a.code;
                }
                return b.start - a.start;
            }
        });
        listMessage.sort(new Comparator<Message>() {
            @Override
            public int compare(Message a, Message b) {
                return a.time - b.time;
            }
        });
        for (Message message : listMessage) {
            int time = message.time;
            for (Consumer consumer : listConsumer) {
                if ((consumer.start > time) || (consumer.end <= time)) {
                    continue;
                }
                consumer.addMessage(message.message);
                break;
            }
        }
    }

    private static List<Consumer> listConsumer(String nextLine) {
        int startIndex = 0;
        int endIndex = 1;
        String[] splits = nextLine.split(" ");
        int len = splits.length;
        List<Consumer> listConsumer = new ArrayList<>();
        int code = 0;
        while (startIndex < len && endIndex < len) {
            int start = Integer.parseInt(splits[startIndex]);
            int end = Integer.parseInt(splits[endIndex]);
            Consumer consumer = new Consumer(start,end);
            consumer.setCode(code++);
            listConsumer.add(consumer);
            startIndex+=2;
            endIndex+=2;
        }
        return listConsumer;
    }

    private static List<Message> listMessage(String nextLine) {
        String[] splits = nextLine.split(" ");
        int len = splits.length;
        int timeIndex = 0;
        int messageIndex = 1;
        List<Message> listMessage = new ArrayList<>();
        while (timeIndex < len && messageIndex < len) {
            int time = Integer.parseInt(splits[timeIndex]);
            String message = splits[messageIndex];
            Message mess = new Message(time,message);
            listMessage.add(mess);
            timeIndex+=2;
            messageIndex+=2;
        }
        return listMessage;
    }

    private static class Message {
        private final int time;
        private final String message;

        public Message(int time, String message) {
            this.time = time;
            this.message = message;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Message)) {
                return false;
            }
            Message other = (Message) obj;
            return time == other.time && message.equals(other.message);
        }
    }

    private static class Consumer {
        private final int start;
        private final int end;
        private int code;

        private List<String> messages = new ArrayList<>();

        public Consumer(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public void addMessage(String message) {
            messages.add(message);
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public int getCode() {
            return code;
        }

        @Override
        public String toString() {
            if (messages.isEmpty()) {
                return "-1";
            }
            return String.join(" ", messages);
        }
    }
}
