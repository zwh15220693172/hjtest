package hjtest.B.hj38支持优先级队列;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] ints = getInts(input.nextLine());
            PriorityQueue<Message> result = getResult(ints);
            String collect = result.stream().map(Message::getVal).map(String::valueOf)
                    .collect(Collectors.joining(","));
            System.out.println(collect);
        }
        input.close();
    }

    private static PriorityQueue<Message> getResult(int[] ints) {
        int valIndex = 0;
        int propertyIndex = 1;
        int len = ints.length;
        PriorityQueue<Message> cursor = new PriorityQueue<>();
        while (valIndex < len && propertyIndex < len) {
            int val = ints[valIndex];
            int property = ints[propertyIndex];
            Message message = new Message(property, val);
            cursor.add(message);
            valIndex+=2;
            propertyIndex+=2;
        }
        PriorityQueue<Message> result = new PriorityQueue<>();
        Message pre = null;
        while (!cursor.isEmpty()) {
            Message poll = cursor.poll();
            if (!poll.equals(pre)) {
                result.add(poll);
                pre = poll;
            }
        }
        return result;
    }

    private static int[] getInts(String inputStr) {
        String replace = inputStr.replaceAll("\\(", "")
                .replaceAll("\\)", "");
        return Arrays.stream(replace.split(","))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static class Message implements Comparable<Message> {
        private final int property;
        private final int val;

        public Message(int property, int val) {
            this.property = property;
            this.val = val;
        }

        public int getProperty() {
            return property;
        }

        public int getVal() {
            return val;
        }

        @Override
        public boolean equals(Object obj) {
            if (Objects.isNull(obj)) {
                return false;
            }
            if (!(obj instanceof Message)) {
                return false;
            }
            Message other = (Message) obj;
            return property == other.property && val == other.val;
        }

        @Override
        public int compareTo(Message other) {
            return other.property - property;
        }
    }
}
