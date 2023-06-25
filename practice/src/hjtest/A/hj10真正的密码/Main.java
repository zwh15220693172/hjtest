package hjtest.A.hj10真正的密码;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            String[] words = listWord(input.nextLine());
            List<String> listStart = listStart(words);
            Optional<String> max = Arrays.stream(words).filter((word) -> listStartContain(word, listStart))
                    .max(new Comparator<String>() {
                        @Override
                        public int compare(String a, String b) {
                            if (a.length() == b.length()) {
                                return a.compareTo(b);
                            } else {
                                return a.length() - b.length();
                            }
                        }
                    });
            if (max.isPresent()) {
                System.out.println(max.get());
            } else {
                System.out.println("NULL");
            }
        }
        input.close();
    }

    private static boolean listStartContain(String word, List<String> listStart) {
        String startChar = word.charAt(0) + "";
        return listStart.contains(startChar);
    }

    private static List<String> listStart(String[] words) {
        return Arrays.stream(words)
                .filter((str) -> str.length() == 1)
                .collect(Collectors.toList());
    }

    private static String[] listWord(String nextLine) {
        return nextLine.split(" ");
    }
}
