package 완전탐색.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold3_알파벳 {

  static char[][] board;
  static boolean used[];
  static int R;
  static int C;

  static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
  static int internalCnt, answer = 0;


  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(in.readLine());

    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    board = new char[R][C];
    used = new boolean[26];

    for (int i = 0; i < R; i++) {
      board[i] = in.readLine().toCharArray();
    }

    used[board[0][0] - 'A'] = true;
    dfs(0, 0, 1);

    System.out.println(answer);
  }

  public static void dfs(int r, int c, int cnt) {
    answer = Math.max(answer, cnt);

    for (int i = 0; i < 4; i++) {
      int dR = r + move[i][0];
      int dC = c + move[i][1];

      if(dR < 0 || dC < 0 || dR >= R || dC >= C) continue;;

      if(!used[board[dR][dC] - 'A']) {
        used[board[dR][dC] - 'A'] = true;
        dfs(dR, dC, cnt+1);
        used[board[dR][dC] - 'A'] = false;
      }
    }
  }
}
