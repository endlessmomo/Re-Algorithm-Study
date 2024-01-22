package 완전탐색.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Gold1_게임 {

  static int answer = 0;
  static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
  static int R, C;
  static int[][] board;
  static int[][] dp;
  static boolean[][] visited;
  static boolean isCircular = false;

  // 1번 조건 전체를 순회하며 최고의 횟수 찾기
  // 2번 패터닝 찾기
  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(in.readLine());

    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    board = new int[R][C];
    dp = new int[R][C];
    visited = new boolean[R][C];
    for (int i = 0; i < R; i++) {
      board[i] = Arrays.stream(in.readLine().replaceAll("H", "0").split(""))
          .mapToInt(Integer::parseInt)
          .toArray();
    }

    // 순회
    visited[0][0] = true;
    dfs(0, 0, 1);
    System.out.println(dp);
    System.out.println(isCircular ? -1 : answer);
  }

  public static void dfs(int r, int c, int cnt) {
    if (cnt > answer) {
      answer = cnt;
    }
    dp[r][c] = cnt;
    for (int i = 0; i < 4; i++) {
      int dR = r + board[r][c] * move[i][0];
      int dC = c + board[r][c] * move[i][1];

      if (dR < 0 || dC < 0 || dR >= R || dC >= C) continue;

      if (board[dR][dC] == 0) continue;


      if (visited[dR][dC]) {
        isCircular = true;
        return;
      }

      if(dp[dR][dC] > cnt) continue;

      visited[dR][dC] = true;
      dfs(dR, dC, cnt + 1);
      visited[dR][dC] = false;
    }
  }
}
