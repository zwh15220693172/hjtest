package hjtest.hj03;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String inputStr = input.nextLine();
            String[] inputStrArray = getInputStrArray(inputStr);
            Map<String, List<String>> map = Arrays.stream(inputStrArray)
                    .collect(Collectors.groupingBy(Function.identity()));
            List<String> resultList = new ArrayList<>();
            map.entrySet().stream().sorted(new Comparator<Map.Entry<String, List<String>>>() {
                @Override
                public int compare(Map.Entry<String, List<String>> a, Map.Entry<String, List<String>> b) {
                    if (a.getValue().size() > b.getValue().size()) {
                        return -1;
                    } else if (a.getValue().size() == b.getValue().size()) {
                        if (a.getKey().length() > b.getKey().length()) {
                            return 1;
                        } else if (a.getKey().length() == b.getKey().length()) {
                            return a.getKey().compareTo(b.getKey());
                        } else {
                            return -1;
                        }
                    } else {
                        return 1;
                    }
                }
            }).map(Map.Entry::getValue).forEach(resultList::addAll);
            String result = String.join(" ", resultList);
            System.out.println(result);
        }
        input.close();
    }

    private static String[] getInputStrArray(String inputStr) {
        String[] splits = inputStr.split(" ");
        String[] inputStrArray = new String[splits.length];
        for (int i = 0; i < splits.length; i++) {
            String cur = splits[i];
            char[] chars = cur.toCharArray();
            Arrays.sort(chars);
            inputStrArray[i] = new String(chars);
        }
        return inputStrArray;
    }
}
