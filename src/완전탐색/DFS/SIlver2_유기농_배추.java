package 완전탐색.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SIlver2_유기농_배추 {

  static int[][] board;
  static boolean[][] visited;

  static int[] dX = {1, 0, -1, 0};
  static int[] dY = {0, 1, 0, -1};
  static int N;
  static int M;

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(in.readLine());

    for (int tries = 0; tries < tc; tries++) {
      StringTokenizer st = new StringTokenizer(in.readLine());
      M = Integer.parseInt(st.nextToken()); // 가로 -> 열
      N = Integer.parseInt(st.nextToken()); // 세로 -> 행
      int locs = Integer.parseInt(st.nextToken());
      int answer = 0;

      // N x M 행렬
      board = new int[N][M];
      visited = new boolean[N][M];


      for (int i = 0; i < locs; i++) {
        st = new StringTokenizer(in.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        board[y][x] = 1;
      }

      for (int y = 0; y < N; y++) {
        for (int x = 0; x < M; x++) {
          if (!visited[y][x] && board[y][x] == 1) {
            dfs(x, y);
            answer++;
          }
        }
      }
      System.out.println(answer);
    }
  }

  public static void dfs(int x, int y) {
    visited[y][x] = true;

    for (int i = 0; i < 4; i++) {
      int dx = x + dX[i];
      int dy = y + dY[i];

      if (dx >= 0 && dy >= 0 && dx < M && dy < N) {
        if (!visited[dy][dx] && board[dy][dx] == 1) {
          dfs(dx, dy);
        }
      }
    }

  }
}
