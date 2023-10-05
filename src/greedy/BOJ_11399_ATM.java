package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11399_ATM {

  public static void main(String[] args) throws IOException {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(in.readLine());
    StringTokenizer st = new StringTokenizer(in.readLine());
    int[] times = new int[N];
    int answer = 0;

    int idx = 0;

    while (st.hasMoreTokens()) {
      times[idx++] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(times);

    int reduce = 0;
    for (int i = 0; i < times.length; i++) {
      reduce += times[i];
      answer += reduce;
    }
    System.out.println(answer);
  }
}
