package hjtest.B.hj68找出经过特定点的路径长度;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final LinkedList<Element> list = new LinkedList<>();
    private static int result;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            list.clear();
            result = Integer.MAX_VALUE;
            String[] sources = input.nextLine().split("");
            List<String> target = Arrays.stream(input.nextLine().split("")).collect(Collectors.toList());
            Map<String,List<Element>> cursor = buildMap(sources, target);
            int len = target.size();
            getResult(0,len,target,cursor);
            System.out.println(result);
        }
        input.close();
    }

    private static void getResult(int index, int end, List<String> target, Map<String, List<Element>> cursor) {
        if (index == end) {
            int sum = 0;
            int last = 0;
            for (int i = 0; i < list.size(); i++) {
                Element cur = list.get(i);
                sum += Math.abs(cur.index - last);
                last = cur.index;
            }
            result = Math.min(result, sum);
            return;
        }
        String curStr = target.get(index);
        if (!cursor.containsKey(curStr)) {
            return;
        }
        List<Element> elements = cursor.get(curStr);
        for (Element element : elements) {
            if (element.use) {
                continue;
            }
            list.addLast(element);
            element.use = true;
            getResult(index+1,end,target,cursor);
            element.use = false;
            list.removeLast();
        }
    }

    private static Map<String, List<Element>> buildMap(String[] sources, List<String> target) {
        HashMap<String,List<Element>> map = new HashMap<>();
        for (int i = 0; i < sources.length; i++) {
            String source = sources[i];
            if (target.contains(source)) {
                List<Element> list;
                if (map.containsKey(source)) {
                    list = map.get(source);
                } else {
                    list = new ArrayList<>();
                    map.put(source,list);
                }
                Element element = new Element(source,i);
                list.add(element);
            }
        }
        return map;
    }

    private static class Element {
        private final String cur;
        private final int index;
        private boolean use;

        public Element(String cur, int index) {
            this.cur = cur;
            this.index = index;
        }
    }
}
