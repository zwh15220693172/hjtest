package hjtest.B.hj50树状结构查询;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int count = Integer.parseInt(input.nextLine());
            Map<String, List<String>> map = buildMap(count, input);
            String target = input.nextLine();
            List<String> result = new ArrayList<>();
            getTarget(target,map,result);
            result.stream().sorted(String::compareTo)
                    .forEach(System.out::println);
        }
        input.close();
    }

    private static void getTarget(String target, Map<String, List<String>> map, List<String> result) {
        if (!map.containsKey(target)) {
            return;
        }
        List<String> childList = map.get(target);
        result.addAll(childList);
        for (String child : childList) {
            getTarget(child,map,result);
        }
    }

    private static Map<String, List<String>> buildMap(int count, Scanner input) {
        Map<String,List<String>> map = new HashMap<>();
        while (count > 0) {
            String[] splits = input.nextLine().split(" ");
            String parent = splits[1];
            String child = splits[0];
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
