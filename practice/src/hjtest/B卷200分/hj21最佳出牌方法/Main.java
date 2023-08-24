package hjtest.B卷200分.hj21最佳出牌方法;

import java.util.Scanner;

/**
 * 100%通过
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            int[] cardCount = getCardCount(input.nextLine());
            int score = getScore(cardCount);
            System.out.println(score);
        }
        input.close();
    }

    private static int getScore(int[] cardCount) {
        int score = 0;
        while (true) {
            int maxShunzi = 0;
            int shunZiIndex = 0;
            for (int i = 1; i <= 9; i++) {
                if (cardCount[i] == 0) {
                    continue;
                }
                int curShunzi = getCurShunzi(cardCount,i);
                if (curShunzi > maxShunzi) {
                    maxShunzi = curShunzi;
                    shunZiIndex = i;
                }
            }
            if (shunZiIndex == 0) {
                break;
            }
            for (int j = shunZiIndex; j <= shunZiIndex + 4; j++) {
                score += j * 2;
                cardCount[j]--;
            }
        }
        for (int i = 1; i < cardCount.length; i++) {
            if (cardCount[i] == 1) {
                score+=i;
            } else if (cardCount[i] == 2) {
                score+=2*i*2;
            } else if (cardCount[i] == 3) {
                score+=3*i*2;
            } else if (cardCount[i] == 4) {
                score+=4*i*3;
            }
        }
        return score;
    }

    private static int getCurShunzi(int[] cardCount, int i) {
        int score = 0;
        for (int j = i; j <= i + 4; j++) {
            if (cardCount[j] == 0) {
                return Integer.MIN_VALUE;
            } else if (cardCount[j] == 1) {
                score+=j;
            } else if (cardCount[j] == 2) {
                score-=j;
            } else if (cardCount[j] == 4){
                score-=4*j;
            }
        }
        return score;
    }

    private static int[] getCardCount(String nextLine) {
        char[] chars = nextLine.toCharArray();
        int[] cardCount = new int[14];
        for (char cur : chars) {
            if (cur == '0') {
                cardCount[10]++;
            } else if (cur == 'J') {
                cardCount[11]++;
            } else if (cur == 'Q') {
                cardCount[12]++;
            } else if (cur == 'K') {
                cardCount[13]++;
            } else {
                cardCount[cur-'0']++;
            }
        }
        return cardCount;
    }
}
