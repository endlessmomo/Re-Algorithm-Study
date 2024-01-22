package 완전탐색.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Gold2_텀_프로젝트 {

  static int[] board;
  static boolean[] consisted;
  static boolean[] internalVisited;
  static int answer;


  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    int tc = Integer.parseInt(in.readLine());

    for (int tries = 0; tries < tc; tries++) {
      int N = Integer.parseInt(in.readLine());

      consisted = new boolean[N];
      internalVisited = new boolean[N];
      answer = 0;

      board = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

      for (int i = 0; i < N; i++) {
        if (!consisted[i]) {
          dfs(i);
        }
      }
      System.out.println(N - answer);
    }
  }

  private static void dfs(int student) {
    if (consisted[student]) {
      return;
    }

    if (internalVisited[student]) {
      consisted[student] = true;
      answer++;
    }

    internalVisited[student] = true;
    dfs(board[student] - 1);
    consisted[student] = true;
    internalVisited[student] = false;

  }
}
