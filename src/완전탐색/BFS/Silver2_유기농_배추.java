package 완전탐색.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver2_유기농_배추 {

  static int N;
  static int M;
  static int[][] board;
  static boolean[][] visited;
  static Queue<Integer[]> queue = new LinkedList<>();
  static int[] dX = {1, 0, -1, 0};
  static int[] dY = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(in.readLine());

    for (int tries = 0; tries < tc; tries++) {
      StringTokenizer st = new StringTokenizer(in.readLine());
      M = Integer.parseInt(st.nextToken());
      N = Integer.parseInt(st.nextToken());
      int row = Integer.parseInt(st.nextToken());

      board = new int[N][M];
      visited = new boolean[N][M];

      for (int i = 0; i < row; i++) {
        st = new StringTokenizer(in.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        board[y][x] = 1;
      }

      int answer = 0;
      for (int y = 0; y < N; y++) {
        for (int x = 0; x < M; x++) {
          if(!visited[y][x] && board[y][x] == 1) {
            bfs(x, y);
            answer++;
          }
        }
      }

      System.out.println(answer);
    }
  }

  public static void bfs(int x, int y) {
    visited[y][x] = true;
    queue.offer(new Integer[]{x, y});

    while (!queue.isEmpty()) {
      Integer[] cur = queue.poll();

      for (int i = 0; i < 4; i++) {
        int dx = cur[0] + dX[i];
        int dy = cur[1] + dY[i];

        if (dx >= 0 && dy >= 0 && dx < M && dy < N) {
          if (!visited[dy][dx] && board[dy][dx] == 1) {
            visited[dy][dx] = true;
            queue.offer(new Integer[]{dx, dy});
          }
        }
      }
    }
  }

}
