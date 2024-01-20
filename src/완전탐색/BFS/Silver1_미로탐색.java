package 완전탐색.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver1_미로탐색 {

  static int[] dX = {1, 0, -1, 0};
  static int[] dY = {0, 1, 0, -1};
  static int N;
  static int M;
  static int[][] board;
  static boolean[][] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(in.readLine());

    N = Integer.parseInt(st.nextToken()); // 행
    M = Integer.parseInt(st.nextToken()); // 열

    board = new int[N][M];
    visited = new boolean[N][M];
    for (int i = 0; i < N; i++) {
      board[i] = Arrays.stream(in.readLine().split(""))
          .mapToInt(Integer::parseInt)
          .toArray();
    }

    int answer = bfs(0, 0);
    System.out.println(answer);
  }

  public static int bfs(int startX, int startY) {
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[] {startX, startY});

    while (!queue.isEmpty()) {
      int[] cur = queue.poll();

      if (cur[0] == N - 1 && cur[1] == M - 1) break;

      for (int i = 0; i < 4; i++) {
        int dx = cur[0] + dX[i];
        int dy = cur[1] + dY[i];

        if (dx >= 0 && dy >= 0 && dy < N && dx < M) {
          if (board[dy][dx] != 0 && !visited[dy][dx]) {
            board[dy][dx] = board[dy][dx] + board[cur[1]][cur[0]];
            visited[dy][dx] = true;
            queue.offer(new int[]{dx, dy});
          }
        }
      }
    }
    return board[N - 1][M - 1];
  }
}
