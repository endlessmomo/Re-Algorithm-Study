package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_14916_거스름돈 {

  // dp 풀이
  public static int[] dp = new int[1000001];
  public static void main(String[] args) throws IOException {

    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int target = Integer.parseInt(in.readLine());

    Arrays.fill(dp, -1);

    dp[2] = 1;
    dp[4] = 2;
    dp[5] = 1;

    for(int i = 6; i <= target; i++) {
      if(dp[i-2] == -1){
        dp[i] = dp[i-5] + 1;
      } else if (dp[i-5] == -1) {
        dp[i] = dp[i-2] + 1;
      } else{
        dp[i] = Math.min(dp[i-5], dp[i-2]) + 1;
      }
    }

    System.out.println(dp[target]);
  }
}
