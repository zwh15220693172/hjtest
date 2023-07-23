package hjtest.B复.hj19热点网站统计;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final List<String> result = new ArrayList<>();
    private static final HashMap<String,News> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            result.clear();
            map.clear();
            getResult(input);
            result.forEach(System.out::println);
        }
        input.close();
    }

    private static void getResult(Scanner input) {
        while (true) {
            String inputStr = input.nextLine();
            if (inputStr.isEmpty()) {
                break;
            }
            if (isDigit(inputStr)) {
                detailDigit(inputStr);
            } else {
                detailStr(inputStr);
            }
        }
    }

    private static void detailStr(String news) {
        News cur;
        if (map.containsKey(news)) {
            cur = map.get(news);
        } else {
            cur = new News(news);
            map.put(news, cur);
        }
        cur.add();
    }

    private static void detailDigit(String inputStr) {
        int limit = Integer.parseInt(inputStr);
        Collection<News> values = map.values();
        String collect = values.stream().sorted(new Comparator<News>() {
            @Override
            public int compare(News a, News b) {
                if (a.count == b.count) {
                    return a.news.compareTo(b.news);
                }
                return b.count - a.count;
            }
        }).limit(limit).map(News::getNews)
                .collect(Collectors.joining(","));
        result.add(collect);
    }

    private static boolean isDigit(String inputStr) {
        return Character.isDigit(inputStr.charAt(0));
    }

    private static class News {
        private final String news;
        private int count;

        public News(String news) {
            this.news = news;
        }

        public void add() {
            this.count++;
        }

        public String getNews() {
            return news;
        }
    }
}
