package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_11508_2and1_게임 {

  public static void main(String[] args) throws IOException {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int row = Integer.parseInt(in.readLine());
    Integer[] price = new Integer[row];
    int answer = 0;

    for (int i = 0; i < row; i++) {
      price[i] = Integer.parseInt(in.readLine());
    }

    Arrays.sort(price, Comparator.reverseOrder());

    int cnt = 0;

    for (Integer integer : price) {
      if (++cnt == 3) {
        cnt = 0;
        continue;
      }
      answer += integer;
    }

    System.out.println(answer);
  }
}
