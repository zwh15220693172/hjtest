package hjtest.B卷200分.hj34荒岛求生;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] numStrList = input.nextLine().split(" ");
        Stack<Integer> cursor = new Stack<>();
        boolean error = false;
        for (String numStr : numStrList) {
            try {
                int num = Integer.parseInt(numStr);
                if (num > 0) {
                    cursor.push(num);
                } else {
                    if (cursor.isEmpty()) {
                        cursor.push(num);
                    } else {
                        boolean add = true;
                        while (!cursor.isEmpty() && cursor.peek() > 0) {
                            if (cursor.peek() > Math.abs(num)) {
                                int pop = cursor.pop();
                                num+=pop;
                                cursor.push(num);
                                add = false;
                                break;
                            } else if (cursor.peek() == Math.abs(num)) {
                                cursor.pop();
                                add = false;
                                break;
                            } else {
                                int pop = cursor.pop();
                                num+=pop;
                            }
                        }
                        if (add) {
                            cursor.add(num);
                        }
                    }
                }
            } catch (Exception e){
                error = true;
                break;
            }
        }
        if (error) {
            System.out.println(-1);
        } else {
            System.out.println(cursor.size());
        }
    }
}
