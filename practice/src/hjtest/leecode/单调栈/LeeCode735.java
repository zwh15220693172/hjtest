package hjtest.leecode.单调栈;

import java.util.Arrays;
import java.util.Stack;

public class LeeCode735 {

    public static void main(String[] args) {
        int[] asteroids = {8,-8};
        String result = Arrays.toString(asteroidCollision(asteroids));
        System.out.println(result);
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> cursor = new Stack<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                cursor.push(asteroid);
            } else {
                if (cursor.isEmpty()) {
                    cursor.push(asteroid);
                } else {
                    boolean curBoom = false;
                    while (!cursor.isEmpty() && cursor.peek() > 0) {
                        int last = cursor.peek();
                        if (last > Math.abs(asteroid)) {
                            curBoom = true;
                            break;
                        } else if (last == Math.abs(asteroid)) {
                            curBoom = true;
                            cursor.pop();
                            break;
                        }else {
                            cursor.pop();
                        }
                    }
                    if (!curBoom) {
                        cursor.push(asteroid);
                    }
                }
            }
        }
        return cursor.stream().mapToInt(Integer::intValue).toArray();
    }
}
