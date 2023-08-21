package hjtest.B复200分.hj15最长的顺子;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String[] chars01 = getChars(input.nextLine());
            String[] chars02 = getChars(input.nextLine());
            HashMap<String,Integer> charCount = buildCharCount(chars01,chars02);
            boolean[] used = buildUsed(charCount);
            String shunZi = getShunZi(used);
            System.out.println(shunZi);
        }
        input.close();
    }

    private static String getShunZi(boolean[] used) {
        List<Integer> path = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int max = 4;
        for (int i = 3; i < used.length; i++) {
            if (used[i]) {
                path.add(i);
            } else {
                if (path.size() >= max) {
                    result.clear();
                    result.addAll(path);
                    max = result.size();
                }
                path.clear();
            }
            if (i == used.length-1) {
                if (path.size() >= max) {
                    result.clear();
                    result.addAll(path);
                    max = result.size();
                }
                path.clear();
            }
        }
        if (result.contains(13) && used[1]) {
            result.add(1);
        }
        if (result.size() < 5) {
            return "NO-CHAIN";
        }
        return getResult(result);
    }

    private static String getResult(List<Integer> result) {
        return result.stream().map((num)->mapResult(num))
                .collect(Collectors.joining("-"));
    }

    private static String mapResult(int num) {
        if (num == 1) {
            return "A";
        } else if (num == 11) {
            return "J";
        } else if (num == 12) {
            return "Q";
        } else if (num == 13) {
            return "K";
        } else {
            return String.valueOf(num);
        }
    }

    private static boolean[] buildUsed(HashMap<String, Integer> charCount) {
        boolean[] used = new boolean[14];
        Arrays.fill(used,true);
        Set<String> cards = charCount.keySet();
        for (String card : cards) {
            int cardNum = charCount.get(card);
            if (cardNum < 4) {
                continue;
            }
            switch (card) {
                case "A":
                    used[1] = false;
                    break;
                case "J":
                    used[11] = false;
                    break;
                case "Q":
                    used[12] = false;
                    break;
                case "K":
                    used[13] = false;
                    break;
                default:
                    used[Integer.parseInt(card)] = false;
                    break;
            }
        }
        return used;
    }

    private static HashMap<String, Integer> buildCharCount(String[] chars01, String[] chars02) {
        HashMap<String,Integer> charCount = new HashMap<>();
        for (String char01 : chars01) {
            charCount.put(char01,charCount.getOrDefault(char01,0)+1);
        }
        for (String char02 : chars02) {
            charCount.put(char02,charCount.getOrDefault(char02,0)+1);
        }
        return charCount;
    }

    private static String[] getChars(String nextLine) {
        return nextLine.split("-");
    }
}
