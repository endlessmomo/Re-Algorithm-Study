package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2828_사과_담기_게임 {

  public static void main(String[] args) throws IOException {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(in.readLine());
    int car = Integer.parseInt(st.nextToken());
    int bucketSize = Integer.parseInt(st.nextToken());
    int tc = Integer.parseInt(in.readLine());

    // 바구니의 시작 위치와 끝값
    // 사과가 떨어지는 위치보다 start가 큰 경우 start 위치의 이동이 되어야한다
    // start -= (start - apple)
    // distance += (start - apple);
    int start = 1;
    int end = bucketSize;
    int distance = 0;

    for (int i = 0; i < tc; i++) {
      int apple = Integer.parseInt(in.readLine());
      if (start > apple) {
        distance += (start - apple);
        end -= (start - apple);
        start = apple;
      } else if (end < apple) {
        distance += (apple - end);
        start += (apple - end);
        end = apple;
      }
    }

    System.out.println(distance);
  }
}
