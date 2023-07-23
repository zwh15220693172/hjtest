package hjtest.B.hj5选修课;

import java.util.*;
import java.util.stream.Collectors;

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
        Map<Integer, Clazz> map = new HashMap<>();
        for (Student student : collect) {
            int code = Integer.parseInt(student.code.substring(0,5));
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
        clazzList.stream().sorted(Comparator.comparing(Clazz::getCode))
                .forEach(Clazz::print);
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
        private final int code;
        private final List<Student> students = new ArrayList<>();

        public Clazz(int code) {
            this.code = code;
        }

        public void addStudent(Student student) {
            students.add(student);
        }

        public int getCode() {
            return code;
        }

        public void print() {
            System.out.println(code);
            String collect = students.stream().sorted(new Comparator<Student>() {
                @Override
                public int compare(Student a, Student b) {
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
