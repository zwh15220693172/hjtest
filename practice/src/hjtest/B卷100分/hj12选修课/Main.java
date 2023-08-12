package hjtest.B卷100分.hj12选修课;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 1.注意，输出的班级号是字符串
 * 2.注意，学生成绩相同的时候，按照学号从小到大排
 * 100%
 * 1.学生对象为student, code = string, scores = list
 * 2.整一个hashmap，key = code, value = student
 * 3.遍历第一行,都放进去
 * 4.遍历第二行，如果存在，那么放进去
 * 5.hashmap.values过滤掉长度不足2的
 * 6.整一个class对象，list为student，code为字符串
 * 7.排序
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            HashMap<String,Student> map = new HashMap<>();
            String paramStr1 = input.nextLine();
            putMap(paramStr1,map);
            String paramStr2 = input.nextLine();
            putMap(paramStr2,map);
            printResult(map);
        }
        input.close();
    }

    private static void printResult(HashMap<String, Student> map) {
        Collection<Student> values = map.values();
        List<Student> collect = values.stream()
                .filter(student -> student.scores.size() >= 2)
                .collect(Collectors.toList());
        if (collect.isEmpty()) {
            System.out.println("NULL");
        } else {
            printContain(collect);
        }
    }

    private static void printContain(List<Student> collect) {
        Map<String, Clazz> map = new HashMap<>();
        for (Student student : collect) {
            String code = student.code.substring(0, 5);
            Clazz clazz;
            if (map.containsKey(code)) {
                clazz = map.get(code);
            } else {
                clazz = new Clazz(code);
                map.put(code,clazz);
            }
            clazz.addStudent(student);
        }
        Collection<Clazz> clazzList = map.values();
        clazzList.stream()
                .sorted(new Comparator<Clazz>() {
                    @Override
                    public int compare(Clazz a, Clazz b) {
                        return Integer.parseInt(a.code)
                                - Integer.parseInt(b.code);
                    }
                }).forEach(Clazz::print);
    }

    private static void putMap(String paramStr, HashMap<String, Student> map) {
        String[] splits = paramStr.split(";");
        for (String split : splits) {
            String[] strings = split.split(",");
            String code = strings[0];
            int score = Integer.parseInt(strings[1]);
            Student student;
            if (map.containsKey(code)) {
                student = map.get(code);
            } else {
                student = new Student(code);
                map.put(code,student);
            }
            student.addScore(score);
        }
    }

    private static class Clazz {
        private final String code;
        private final List<Student> students = new ArrayList<>();

        public Clazz(String code) {
            this.code = code;
        }

        public void addStudent(Student student) {
            students.add(student);
        }

        public String getCode() {
            return code;
        }

        public void print() {
            System.out.println(code);
            String collect = students.stream().sorted(new Comparator<Student>() {
                @Override
                public int compare(Student a, Student b) {
                    if (b.total == a.total) {
                        return Integer.parseInt(a.code)
                                - Integer.parseInt(b.code);
                    }
                    return b.total - a.total;
                }
            }).map(Student::getCode).collect(Collectors.joining(";"));
            System.out.println(collect);
        }
    }

    private static class Student {
        private final String code;
        private final List<Integer> scores = new ArrayList<>();
        private int total;
        public Student(String code) {
            this.code = code;
        }
        public void addScore(int score) {
            scores.add(score);
            total+=score;
        }

        public int total() {
            return this.total;
        }

        public String getCode() {
            return code;
        }
    }
}
