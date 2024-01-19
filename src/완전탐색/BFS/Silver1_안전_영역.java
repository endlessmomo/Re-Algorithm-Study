package 완전탐색.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Silver1_안전_영역 {

  static int[][] board;
  static boolean[][] visited;
  static int[] dX = {1, 0, -1, 0};
  static int[] dY = {0, 1, 0, -1};
  static int N;
  static int res = Integer.MIN_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(in.readLine());
    board = new int[N][N];

//    int maxH = 0;
//    for (int i = 0; i < N; i++) {
//      StringTokenizer st = new StringTokenizer(in.readLine());
//      for (int j = 0; j < N; j++) {
//        board[i][j] = Integer.parseInt(st.nextToken());
//        maxH = Math.max(maxH, board[i][j]);
//      }
//    }

    for (int i = 0; i < N; i++) {
      board[i] = Arrays.stream(in.readLine().split(" "))
          .mapToInt(Integer::parseInt)
          .toArray();
    }

    int maxH = Arrays.stream(board)
        .flatMapToInt(Arrays::stream)
        .max()
        .orElseThrow();

    //n^#
    for (int h = 0; h < maxH; h++) {
      int cnt = 0;
      visited = new boolean[N][N];
      for (int y = 0; y < N; y++) {
        for (int x = 0; x < N; x++) {
          if (!visited[y][x] && board[y][x] > h) {
            bfs(y, x, h);
            cnt++;
          }
        }
      }
      res = Math.max(res, cnt);
    }
    System.out.println(res);
  }

  static Queue<int[]> queue = new LinkedList<>();
  public static void bfs(int y, int x, int curH) {
    queue.offer(new int[]{y, x});

    while (!queue.isEmpty()) {
      int[] cur = queue.poll();

      for (int i = 0; i < 4; i++) {
        int dx = cur[1] + dX[i];
        int dy = cur[0] + dY[i];

        if (dy < 0 || dx < 0 || dy >= N || dx >= N) {
          continue;
        }

        if (!visited[dy][dx] && board[dy][dx] > curH) {
          visited[dy][dx] = true;
          queue.offer(new int[]{dy, dx});
        }
      }
    }
  }
}
