package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS_DFS {

  // BFS -> 너비 우선 탐색
  // DFS -> 깊이 우선 탐색
  static List<List<Integer>> vertexs = new ArrayList<>();
  static boolean visited[];
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(in.readLine());

    int N = Integer.parseInt(st.nextToken()); // vertex 개수
    int M = Integer.parseInt(st.nextToken()); // edge 개수
    int V = Integer.parseInt(st.nextToken()); // start

    for (int i = 0; i <= N; i++) {
      vertexs.add(new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(in.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());

      vertexs.get(start).add(end);
      vertexs.get(end).add(start);
    }

    vertexs.forEach(Collections::sort);

    visited = new boolean[N + 1];

    try {
      dfs(V);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      Arrays.fill(visited, false);
      sb.append("\n");
    }

    bfs(V);
  }

  public static void dfs(int start) {
    visited[start] = true;
    sb.append(start);

    for (int next : vertexs.get(start)) {
      if (!visited[next]) {
        sb.append(" ");
        dfs(next);
      }
    }
  }

  public static void bfs(int start) {
    Queue<Integer> queue = new LinkedList<>();

    queue.add(start);
    visited[start] = true;
    sb.append(start).append(" ");

    while (!queue.isEmpty()) {
      int cur = queue.poll();

      for(int next : vertexs.get(cur)){
        if(!visited[next]){
          queue.add(next);
          visited[next] = true;
          sb.append(next).append(" ");
        }
      }
    }

    System.out.println(sb.substring(0, sb.length()-1));
  }
}
