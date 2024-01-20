package 완전탐색.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Silver1_음식물_피하기 {

  static int N;
  static int M;
  static int[][] board;
  static boolean[][] visited;
  static final int INF = -1;
  static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

  static int answer = 0;
  static int internalCnt = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(in.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    int row = Integer.parseInt(st.nextToken());

    board = new int[N + 1][M + 1];
    visited = new boolean[N + 1][M + 1];

    for (int i = 0; i <= N; i++) {
      Arrays.fill(board[i], INF);
    }

    for (int i = 0; i < row; i++) {
      st = new StringTokenizer(in.readLine());
      int r = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());

      board[r][c] = 1;
    }

    for (int r = 1; r <= N; r++) {
      for (int c = 1; c <= M; c++) {
        if (!visited[r][c] && board[r][c] != -1) {
          internalCnt = 0;
          dfs(r, c);
          answer = Math.max(answer, internalCnt);
        }
      }
    }

    System.out.println(answer);
  }

  // dfs가 순회할 때마다 cnt는 어떻게ㅃ
  public static void dfs(int r, int c) {
    visited[r][c] = true;
    internalCnt++;

    for (int i = 0; i < 4; i++) {
      int dR = r + move[i][0];
      int dC = c + move[i][1];

      if (dR < 1 || dC < 1 || dR > N || dC > M) {
        continue;
      }

      if (!visited[dR][dC] && board[dR][dC] != -1) {
        dfs(dR, dC);
      }
    }
  }
}
