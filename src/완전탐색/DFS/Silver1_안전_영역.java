package 완전탐색.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Silver1_안전_영역 {

  static int N;
  static int[][] board;
  static boolean[][] checked;
  static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
  static int answer = Integer.MIN_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(in.readLine());
    board = new int[N][N];

    for (int i = 0; i < N; i++) {
      board[i] = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    int maxH = Arrays.stream(board)
        .flatMapToInt(Arrays::stream)
        .max()
        .getAsInt();

    for (int h = 0; h < maxH; h++) {
      checked = new boolean[N][N];
      int count = 0;
      for (int row = 0; row < N; row++) {
        for (int col = 0; col < N; col++) {
          if (!checked[row][col] && board[row][col] > h) {
            count++;
            dfs(row, col, h);
          }
        }
      }
      answer = Math.max(answer, count);
    }
    System.out.println(answer);
  }

  public static void dfs(int row, int col, int h) {
    checked[row][col] = true;

    for (int i = 0; i < 4; i++) {
      int dR = row + move[i][0];
      int dC = col + move[i][1];

      if(dR < 0 || dC < 0 || dR >= N || dC >= N) continue;
      if (!checked[dR][dC] && board[dR][dC] > h) {
        dfs(dR, dC, h);
      }
    }
  }

}
