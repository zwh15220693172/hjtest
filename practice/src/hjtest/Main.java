package hjtest;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int count = Integer.parseInt(input.nextLine());
            HashMap<String,List<String>> parentChildList = listParentChild(count, input);
            String start = input.nextLine();
            List<String> path = new ArrayList<>();
            backtracking(start,parentChildList,path);
            path.stream().sorted().forEach(System.out::println);
        }
        input.close();
    }

    private static void backtracking(String cur, HashMap<String, List<String>> parentChildList, List<String> path) {
        if (!parentChildList.containsKey(cur)) {
            return;
        }
        List<String> strings = parentChildList.get(cur);
        path.addAll(strings);
        for (String string : strings) {
            backtracking(string,parentChildList,path);
        }
    }

    private static HashMap<String, List<String>> listParentChild(int count, Scanner input) {
        HashMap<String,List<String>> map = new HashMap<>();
        while (count > 0) {
            String[] strings = input.nextLine().split(" ");
            String parent = strings[1];
            String child = strings[0];
            List<String> list;
            if (map.containsKey(parent)) {
                list = map.get(parent);
            } else {
                list = new ArrayList<>();
                map.put(parent,list);
            }
            list.add(child);
            count--;
        }
        return map;
    }
}
