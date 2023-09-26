package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_13305_주유소 {

  public static void main(String[] args) throws IOException {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    int graph = Integer.parseInt(in.readLine());
    long[] distance = new long[graph - 1];
    long[] price = new long[graph];
    long answer = 0;

    distance = Arrays.stream(in.readLine().split(" "))
        .mapToLong(Long::parseLong)
        .toArray();

    price = Arrays.stream(in.readLine().split(" "))
        .mapToLong(Long::parseLong)
        .toArray();

    long min = price[0];

    for (int i = 0; i < distance.length; i++) {
      if (price[i] < min) {
        min = price[i];
      }
      answer += min * distance[i];
    }
    System.out.println(answer);
  }
}