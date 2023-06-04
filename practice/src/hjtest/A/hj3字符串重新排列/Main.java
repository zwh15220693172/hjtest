package hjtest.A.hj3字符串重新排列;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String[] splits = getSplits(input.nextLine());
            Map<String, List<String>> map = Arrays.stream(splits).collect(Collectors.groupingBy(Function.identity()));
            List<String> result = new ArrayList<>();
            map.entrySet().stream().sorted(new Comparator<Map.Entry<String, List<String>>>() {
                @Override
                public int compare(Map.Entry<String, List<String>> a, Map.Entry<String, List<String>> b) {
                    if (a.getValue().size() < b.getValue().size()) {
                        return 1;
                    } else if (a.getValue().size() == b.getValue().size()) {
                        if (a.getKey().length() > b.getKey().length()) {
                            return 1;
                        } else if (a.getKey().length() == b.getKey().length()) {
                            return a.getKey().compareTo(b.getKey());
                        } else {
                            return -1;
                        }
                    } else {
                        return -1;
                    }
                }
            }).forEach((stringListEntry)->result.addAll(stringListEntry.getValue()));
            System.out.println(String.join(" ", result));
        }
        input.close();
    }

    private static String[] getSplits(String nextLine) {
        String[] splits = nextLine.split(" ");
        String[] target = new String[splits.length];
        int index = 0;
        while (index < splits.length) {
            String split = splits[index];
            char[] chars = split.toCharArray();
            Arrays.sort(chars);
            target[index] = new String(chars);
            index++;
        }
        return target;
    }


}
