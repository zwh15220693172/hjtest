package hjtest.leecode.单调栈;

import java.util.*;
import java.util.stream.Collectors;

public class LeeCode735 {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> left = getLeft(asteroids);
        List<Integer> right = getRight(asteroids);
        left.addAll(right);
        return left.stream().mapToInt(Integer::intValue).toArray();
    }

    private List<Integer> getRight(int[] asteroids) {
        Stack<Integer> cursor = new Stack<>();
        LinkedList<Integer> result = new LinkedList<>();
        for (int i = asteroids.length - 1; i >= 0; i--) {
            int asteroid = asteroids[i];
            if (asteroid < 0) {
                cursor.push(asteroid);
                continue;
            }
            if (cursor.isEmpty() && asteroid > 0) {
                result.addFirst(asteroid);
                continue;
            }
            while (!cursor.isEmpty() && -cursor.peek() < asteroid) {
                cursor.pop();
            }
            if (!cursor.isEmpty() &&  -cursor.peek() == asteroid) {
                cursor.pop();
                continue;
            }
            if (cursor.isEmpty()) {
                result.addFirst(asteroid);
            }
        }
        return result;
    }

    private List<Integer> getLeft(int[] asteroids) {
        Stack<Integer> cursor = new Stack<>();
        LinkedList<Integer> result = new LinkedList<>();
        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                cursor.push(asteroid);
                continue;
            }
            if (cursor.isEmpty() && asteroid < 0) {
                result.addLast(asteroid);
                continue;
            }
            int cur = -asteroid;
            while (!cursor.isEmpty() && cursor.peek() < cur) {
                cursor.pop();
            }
            if (!cursor.isEmpty() && cursor.peek() == cur) {
                cursor.pop();
                continue;
            }
            if (cursor.isEmpty()) {
                result.addLast(asteroid);
            }
        }
        return result;
    }
}
