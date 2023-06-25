package hjtest.B.hj34字符串化繁为简;


import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            char[] chars = input.nextLine().toLowerCase().toCharArray();
            String result = getResult(chars);
            System.out.println(result);
        }
        input.close();
    }

    private static String getResult(char[] chars) {
        Character[] withOutBracket = withOutBracket(chars);
        LinkedHashSet<Character>[] lists = inBracket(chars);
        merge(lists);
        List<PriorityQueue<Character>> listInBracket = listInBracket(lists);
        char[] resultChars = new char[withOutBracket.length];
        for (int i = 0; i < withOutBracket.length; i++) {
            char cur = withOutBracket[i];
            for (PriorityQueue<Character> characters : listInBracket) {
                if (characters.contains(cur)) {
                    cur = characters.peek();
                    break;
                }
            }
            resultChars[i] = cur;
        }
        return new String(resultChars);
    }

    private static List<PriorityQueue<Character>> listInBracket(LinkedHashSet<Character>[] lists) {
        return Arrays.stream(lists).filter(Objects::nonNull)
                .filter((list)->list.size() >0).map(PriorityQueue::new)
                .collect(Collectors.toList());
    }


    private static void merge(LinkedHashSet<Character>[] lists) {
        for (int i = 0; i < lists.length; i++) {
            for (int j = i + 1; j < lists.length; j++) {
                LinkedHashSet<Character> set = new LinkedHashSet<>();
                if (Objects.isNull(lists[i]) || Objects.isNull(lists[j])) {
                    continue;
                }
                set.addAll(lists[i]);
                set.addAll(lists[j]);
                if (set.size() < lists[i].size() + lists[j].size()) {
                    lists[i] = set;
                    lists[j] = null;
                    merge(lists);
                }
            }
        }
    }

    private static LinkedHashSet<Character>[] inBracket(char[] chars) {
        List<LinkedHashSet<Character>> list = new ArrayList<>();
        boolean add = false;
        List<Character> path = new ArrayList<>();
        for (char cur : chars) {
            if (cur == '(') {
                add = true;
                path.clear();
            } else if (cur == ')') {
                add = false;
                list.add(new LinkedHashSet<>(path));
            }
            if (cur != '(' && add) {
                path.add(cur);
            }
        }
        return list.toArray(new LinkedHashSet[0]);
    }

    private static Character[] withOutBracket(char[] chars) {
        boolean add = true;
        List<Character> list = new ArrayList<>();
        for (char cur : chars) {
            if (cur == '(') {
                add = false;
            }
            if (cur == ')') {
                add = true;
            }
            if (cur != '(' && cur != ')' && add) {
                list.add(cur);
            }
        }
        return list.toArray(new Character[0]);
    }
}
