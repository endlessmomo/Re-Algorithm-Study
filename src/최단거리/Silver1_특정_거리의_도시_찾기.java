package 최단거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver1_특정_거리의_도시_찾기 {

  static final int INF = -1;
  static List<Integer> answer = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(in.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int start = Integer.parseInt(st.nextToken());

    List<Integer>[] cities = new List[N + 1];

    for (int i = 1; i <= N; i++) {
      cities[i] = new ArrayList<>();
    }

    for (int i = 1; i <= M; i++) {
      st = new StringTokenizer(in.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      cities[a].add(b);
    }

    int[] dist = new int[N + 1];
    Queue<Integer> queue = new ArrayDeque<>();
    Arrays.fill(dist, INF);
    queue.add(start);
    dist[start] = 0;

    while (!queue.isEmpty()) {
      int cur = queue.poll();
      if (dist[cur] > K) {
        break;
      }
      if (dist[cur] == K) {
        answer.add(cur);
      }

      for (int next : cities[cur]) {
        if (dist[next] != INF) {
          continue;
        }
        dist[next] = dist[cur] + 1;
        queue.add(next);
      }
    }

    if (answer.isEmpty()) {
      System.out.println("-1");
    } else {
      answer.stream().sorted()
          .forEach(System.out::println);
    }
  }
}
