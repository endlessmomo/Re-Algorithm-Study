package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_1758_알바생_강호 {

  public static void main(String[] args) throws IOException {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int row = Integer.parseInt(in.readLine());
    Integer[] tips = new Integer[row];
    long answer = 0;

    for (int i = 0; i < row; i++) {
      tips[i] = Integer.parseInt(in.readLine());
    }

    Arrays.sort(tips, Comparator.reverseOrder());

    for (int i = 0; i < row; i++) {
      if(tips[i] - i <= 0){
        break;
      }

      answer +=tips[i] - i;
    }
    System.out.println(answer);
  }
}
