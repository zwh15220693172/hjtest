package hjtest.B卷200分.hj21最佳出牌方法;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] cardCount = buildCardCount(input.nextLine());
        int sum = 0;
        while (true) {
            int maxShunZi = 0;
            int shunZiIndex = -1;
            for (int i = 1; i < cardCount.length; i++) {
                if (cardCount[i] == 0) {
                    continue;
                }
                int curShunZi = shunZi(i,cardCount);
                if (curShunZi > maxShunZi) {
                    maxShunZi = curShunZi;
                    shunZiIndex = i;
                }
            }
            if (shunZiIndex == -1) {
                break;
            }
            for (int i = shunZiIndex; i < shunZiIndex + 5; i++) {
                sum += 2 * i;
                cardCount[i]--;
            }
        }
        for (int i = 1; i < cardCount.length; i++) {
            if (cardCount[i] == 1) {
                sum+=i;
            } else if (cardCount[i] == 2) {
                sum+=2*2*i;
            } else if (cardCount[i] == 3){
                sum+=2*3*i;
            } else if (cardCount[i] == 4) {
                sum+=4*3*i;
            }
        }
        System.out.println(sum);
    }

    private static int shunZi(int start, int[] cardCount) {
        int end = start + 5;
        int sum = 0;
        if (end > cardCount.length) {
            return -1;
        }
        for (int i = start; i < end; i++) {
            if (cardCount[i] == 0) {
                return -1;
            }
            if (cardCount[i] == 1) {
                sum+=i;
            } else if (cardCount[i] == 2) {
                sum-=i;
            } else if (cardCount[i] == 4) {
                sum -= 4*i;
            }
        }
        return sum;
    }

    private static int[] buildCardCount(String nextLine) {
        int[] cardCount = new int[14];
        String[] splits = nextLine.split("");
        for (String split : splits) {
            int card = getCard(split);
            cardCount[card]++;
        }
        return cardCount;
    }

    private static int getCard(String split) {
        switch (split) {
            case "0":
                return 10;
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            default:
                return Integer.parseInt(split);
        }
    }
}
