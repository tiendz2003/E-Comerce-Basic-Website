package Search;

import java.util.PriorityQueue;
import java.util.Comparator;

public class KnightonChessboard {
    public static void main(String[] args) {
        KnightonChessboard sol = new KnightonChessboard();
        int N = 8, M = 8;
        int x1 = 1, y1 = 1, x2 = 8, y2 = 8;
        int result = sol.knight(N, M, x1, y1, x2, y2);
        System.out.println("Số bước di chuyển ngắn nhất: " + result);
    }

    public int knight(int N, int M, int x1, int y1, int x2, int y2) {
        int[] dx = {-1, -2, -1, -2, 1, 2, 1, 2};
        int[] dy = {-2, -1, 2, 1, -2, -1, 2, 1};
        boolean[][] isVisited = new boolean[N+1][M+1];

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.f));
        queue.add(new Node(x1, y1, 0, manhattanDistance(x1, y1, x2, y2)));
        isVisited[x1][y1] = true;

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            if (curr.x == x2 && curr.y == y2) {
                return curr.g;
            }

            for (int i = 0; i < 8; i++) {
                int newX = curr.x + dx[i];
                int newY = curr.y + dy[i];

                if (isValid(newX, newY, N, M) && !isVisited[newX][newY]) {
                    int g = curr.g + 1;
                    int h = manhattanDistance(newX, newY, x2, y2);
                    queue.add(new Node(newX, newY, g, g + h));
                    isVisited[newX][newY] = true;
                }
            }
        }

        return -1;
    }

    private int manhattanDistance(int x1, int y1, int x2, int y2) {
        return (Math.abs(x1 - x2) + Math.abs(y1 - y2)) / 3; // Chia 3 để giảm heuristic cho quân mã
    }

    private boolean isValid(int x, int y, int N, int M) {
        return x > 0 && y > 0 && x <= N && y <= M;
    }

    static class Node {
        int x, y, g, f;

        public Node(int x, int y, int g, int f) {
            this.x = x;
            this.y = y;
            this.g = g;
            this.f = f;
        }
    }
}
