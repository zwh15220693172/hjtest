package hjtest.B复100分.hj95数大雁;

import java.util.*;

/**
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            char[] source = input.nextLine().toCharArray();
            int[] charCount = new int[5];
            LinkedList<Integer> qIndex = new LinkedList<>();
            Map<Character, Integer> charIndex = getCharIndex();
            List<int[]> ints = new ArrayList<>();
            for (int i = 0; i < source.length; i++) {
                char cur = source[i];
                int index = charIndex.get(cur);
                if (cur == 'q') {
                    qIndex.add(i);
                    charCount[0]++;
                } else if (cur == 'k') {
                    if (charCount[index] < charCount[index-1]) {
                        charCount[index]++;
                        ints.add(new int[]{qIndex.pop(),i});
                    }
                } else {
                    if (charCount[index] < charCount[index-1]) {
                        charCount[index]++;
                    }
                }
            }
            if (ints.isEmpty()) {
                System.out.println(-1);
            } else {
                int max = 1;
                int count = 1;
                int[] pre = ints.get(0);
                for (int i = 1; i < ints.size(); i++) {
                    int[] cur = ints.get(i);
                    if (cur[0] < pre[1]) {
                        count++;
                        max = Math.max(count,max);
                    } else {
                        pre = cur;
                        count = 1;
                    }
                }
                System.out.println(max);
            }
        }
        input.close();
    }

    private static Map<Character,Integer> getCharIndex() {
        Map<Character,Integer> charIndex = new HashMap<>();
        charIndex.put('q',0);
        charIndex.put('u',1);
        charIndex.put('a',2);
        charIndex.put('c',3);
        charIndex.put('k',4);
        return charIndex;
    }
}
