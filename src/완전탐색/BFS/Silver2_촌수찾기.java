package 완전탐색.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver2_촌수찾기 {

  static int[] distance;
  static final int INF = -1;
  public static void main(String[] args) throws IOException {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(in.readLine());

    StringTokenizer st = new StringTokenizer(in.readLine());
    int start = Integer.parseInt(st.nextToken());
    int target = Integer.parseInt(st.nextToken());

    int M = Integer.parseInt(in.readLine());

    distance = new int[N + 1];
    Arrays.fill(distance, -1);

    List<Integer>[] edges = new List[N + 1];
    for (int i = 1; i <= N; i++) {
      edges[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(in.readLine());
      int parent = Integer.parseInt(st.nextToken());
      int child = Integer.parseInt(st.nextToken());

      edges[parent].add(child);
      edges[child].add(parent);
    }

    Queue<Integer> queue = new LinkedList<>();
    queue.offer(start);
    distance[start] = 0;

    while (!queue.isEmpty()) {
      int cur = queue.poll();

      if(cur == target) {
        break;
      }

      for (int next : edges[cur]) {
        if(distance[next] == INF) {
          queue.add(next);
          distance[next] = distance[cur] + 1;
        }
      }
    }

    System.out.println(distance[target]);
  }
}
