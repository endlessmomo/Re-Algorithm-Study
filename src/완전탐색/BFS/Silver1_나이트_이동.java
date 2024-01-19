package 완전탐색.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver1_나이트_이동 {

  static int[][] board;
  // 위 (왼, 오) -> 오른쪽 (위, 아래) -> 아래 (왼, 오) -> 왼쪽(위,아래)
  static int[] dX = {-1, 1, 2, 2, -1, 1, -2, -2};
  static int[] dY = {-2, -2, -1, 1, 2, 2, -1, 1};
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    int tc = Integer.parseInt(in.readLine());

    for (int tries = 0; tries < tc; tries++) {
      N = Integer.parseInt(in.readLine());
      board = new int[N][N];

      StringTokenizer st = new StringTokenizer(in.readLine());
      int startY = Integer.parseInt(st.nextToken());
      int startX = Integer.parseInt(st.nextToken());

      st = new StringTokenizer(in.readLine());
      int targetY = Integer.parseInt(st.nextToken());
      int targetX = Integer.parseInt(st.nextToken());

      bfs(new int[]{startX, startY}, new int[]{targetX, targetY});
      System.out.println(board[targetY][targetX]);
    }
  }

  static Queue<int[]> queue = new LinkedList<>();
  public static void bfs(int[] sPoint, int[] tPoint) {
    if (sPoint[0] == tPoint[0] && sPoint[1] == tPoint[1]) {
      return;
    }

    queue.offer(sPoint);

    while (!queue.isEmpty()) {
      int[] cur = queue.poll();
      int curX = cur[0];
      int curY = cur[1];

      if (board[tPoint[1]][tPoint[0]] != 0) {
        queue.clear();
        return;
      }

      for (int i = 0; i < 8; i++) {
        int dx = curX + dX[i];
        int dy = curY + dY[i];

        if (dx < 0 || dy < 0 || dx >= N || dy >= N || board[dy][dx] != 0) {
          continue;
        }

        board[dy][dx] = board[curY][curX] + 1;
        queue.offer(new int[]{dx, dy});
      }
    }
  }
}