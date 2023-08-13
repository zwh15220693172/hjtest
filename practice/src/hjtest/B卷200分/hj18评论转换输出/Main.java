package hjtest.B卷200分.hj18评论转换输出;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 要注意的事情是，A,2,B,0,C,1,D,0,E,0
 * 这种时候，A的下级为B,E,并不是后面两个为A的层级
 * 1.输出char, child，level的对象MyChar对象
 * 2.遍历数据，输出一个List<MyChar>
 * 3.开始对每一个MyChar对象设置level,递归设置，并且返回设置结果，因此层级下有可能设置失败，这个时候需要设置下一个值
 * 4.根据level对结果进行输出工作
 * 5.级别也要进行输出
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            List<MyChar> listMyChar = listMyChar(input.nextLine());
            for (int i = 0; i < listMyChar.size(); i++) {
                setLevel(i,listMyChar,1);
            }
            int maxLevel = listMyChar.stream().max(Comparator.comparing(MyChar::getLevel)).map(MyChar::getLevel).get();
            System.out.println(maxLevel);
            Map<Integer, List<MyChar>> map = listMyChar.stream().collect(Collectors.groupingBy(MyChar::getLevel));
            map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach((entry)->{
                String collect = entry.getValue().stream().map(MyChar::getValue)
                        .collect(Collectors.joining(" "));
                System.out.println(collect);
            });
        }
        input.close();
    }

    private static boolean setLevel(int index, List<MyChar> listMyChar, int level) {
        if (index >= listMyChar.size()) {
            return false;
        }
        MyChar myChar = listMyChar.get(index);
        if (myChar.level != 0) {
            return false;
        }
        myChar.level = level;
        if (myChar.child == 0) {
            return true;
        }
        int count = myChar.child;
        while (count > 0) {
            if (setLevel(++index,listMyChar,level+1)) {
                count--;
            }
        }
        return true;
    }

    private static List<MyChar> listMyChar(String nextLine) {
        int valueIndex = 0;
        int childIndex = 1;
        List<MyChar> listMyChar = new ArrayList<>();
        String[] splits = nextLine.split(",");
        while (valueIndex < splits.length && childIndex < splits.length) {
            String value = splits[valueIndex];
            int child = Integer.parseInt(splits[childIndex]);
            MyChar myChar = new MyChar(value,child);
            listMyChar.add(myChar);
            valueIndex+=2;
            childIndex+=2;
        }
        return listMyChar;
    }

    private static class MyChar {
        private final String value;
        private final int child;
        private int level;

        public MyChar(String value, int child) {
            this.value = value;
            this.child = child;
        }

        public MyChar(String value, int child, int level) {
            this.value = value;
            this.child = child;
            this.level = level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public String getValue() {
            return value;
        }

        public int getChild() {
            return child;
        }

        public int getLevel() {
            return level;
        }
    }
}
