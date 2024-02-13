package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Gold4_N_Queen {

  static int N, count = 0;
  static int[] board;

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(in.readLine());
    board = new int[N];

    bt(0);
    System.out.println(count);
  }

  public static void bt(int row) {
    if (row == N) {
      count++;
      return;
    }

    for (int col = 0; col < N; col++) {
      // 배열의 인덱스는 row를 의미하고, value는 col을 의미한다.
      board[row] = col;

      if (promising(row)) {
        bt(row + 1);
      }
    }
  }

  // 놓을 열에 열,대각선에 또 다른 퀸이 놓여져 있지 않은지 확인한다.
  public static boolean promising(int row) {
    for (int i = 0; i < row; i++) {
      // 같은 열의 존재하는지 확인한다.
      if(board[row] == board[i]) return false;


      // 대각선이 존재하는지 확인한다.
      if(Math.abs(row - i) == Math.abs(board[row] - board[i])) return false;
    }
    return true;
  }
}
