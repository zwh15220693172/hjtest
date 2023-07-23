package hjtest.A.hj18打印机队列;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    private static final PriorityQueue<MyFile> list1 = new PriorityQueue<>();
    private static final PriorityQueue<MyFile> list2 = new PriorityQueue<>();
    private static final PriorityQueue<MyFile> list3 = new PriorityQueue<>();
    private static final PriorityQueue<MyFile> list4 = new PriorityQueue<>();
    private static final PriorityQueue<MyFile> list5 = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            clear();
            int count = Integer.parseInt(input.nextLine());
            List<String> commands = listCommands(count, input);
            int code = 1;
            for (String command : commands) {
                if (command.startsWith("IN")) {
                    String[] splits = command.split(" ");
                    int index = Integer.parseInt(splits[1]);
                    int property = Integer.parseInt(splits[2]);
                    MyFile myFile = new MyFile(property, code++);
                    PriorityQueue<MyFile> target = getQueueByIndex(index);
                    target.add(myFile);
                } else {
                    String[] splits = command.split(" ");
                    int index = Integer.parseInt(splits[1]);
                    PriorityQueue<MyFile> target = getQueueByIndex(index);
                    if (target.isEmpty()) {
                        System.out.println("NULL");
                    } else {
                        System.out.println(target.poll());
                    }
                }
            }
        }
        input.close();
    }

    private static PriorityQueue<MyFile> getQueueByIndex(int index) {
        PriorityQueue<MyFile> target;
        if (index == 1) {
            target = list1;
        } else if (index == 2) {
            target = list2;
        } else if (index == 3) {
            target = list3;
        } else if (index == 4) {
            target = list4;
        } else {
            target = list5;
        }
        return target;
    }

    private static void clear() {
        list1.clear();
        list2.clear();
        list3.clear();
        list4.clear();
        list5.clear();
    }

    private static List<String> listCommands(int count, Scanner input) {
        List<String> listCommand = new ArrayList<>();
        while (count > 0) {
            listCommand.add(input.nextLine());
            count--;
        }
        return listCommand;
    }

    private static class MyFile implements Comparable<MyFile> {
        private final int property;
        private final int code;

        public MyFile(int property, int code) {
            this.code = code;
            this.property = property;
        }

        @Override
        public int compareTo(MyFile myFile) {
            return myFile.property - property;
        }

        @Override
        public String toString() {
            return String.valueOf(code);
        }
    }
}
