package hjtest.B复200分.hj03贪吃蛇;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static int[] director;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            director = new int[]{0,-1};
            List<String> commands = listCommand(input.nextLine());
            int[] mnInts = getInts(input.nextLine());
            int m = mnInts[0];
            int n = mnInts[1];
            String[][] grid = buildGrid(m,n,input);
            LinkedList<int[]> snake = getHead(m,n,grid);
            for (String command : commands) {
                if (command.equals("U")) {
                    director = new int[] {-1,0};
                } else if (command.equals("D")) {
                    director = new int[] {1,0};
                } else if (command.equals("L")) {
                    director = new int[] {0,-1};
                } else if (command.equals("R")) {
                    director = new int[] {0,1};
                } else {
                    int[] head = snake.getFirst();
                    int x = head[0] + director[0];
                    int y = head[1] + director[1];
                    if (x < 0 || x >= m || y < 0 || y >= n) {
                        break;
                    }
                    if (grid[x][y].equals("E")) {
                        int[] tail = snake.removeLast();
                        grid[tail[0]][tail[1]] = "E";
                        grid[x][y] = "H";
                        snake.addFirst(new int[]{x,y});
                    } else if (grid[x][y].equals("F")) {
                        grid[x][y] = "H";
                        snake.addFirst(new int[]{x,y});
                    } else {
                        int[] tail = snake.getLast();
                        if (tail[0] == x && tail[1] == y) {
                            snake.addFirst(snake.removeLast());
                        } else {
                            break;
                        }
                    }
                }
            }
            System.out.println(snake.size());
        }
        input.close();
    }

    private static LinkedList<int[]> getHead(int m, int n, String[][] grid) {
        LinkedList<int[]> list = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j].equals("H")) {
                    list.add(new int[]{i,j});
                    break;
                }
            }
        }
        return list;
    }

    private static String[][] buildGrid(int m, int n, Scanner input) {
        String[][] grid = new String[m][n];
        int index = 0;
        while (index < m) {
            grid[index++] = input.nextLine().split(" ");
        }
        return grid;
    }

    private static int[] getInts(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();
    }

    private static List<String> listCommand(String nextLine) {
        return Arrays.stream(nextLine.split(" "))
                .collect(Collectors.toList());
    }
}
