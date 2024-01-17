package 최단거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Silver2_경로_찾기 {

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(in.readLine());
    StringTokenizer st;

    int[][] map = new int[N][N];

    for(int i = 0; i < N; i++){
      map[i] = Arrays.stream(in.readLine().split(" "))
          .mapToInt(Integer::parseInt).toArray();
    }

    // k는 경유지, 즉 i에서 k로 가고, k에서 j로 갈 수 있다면 i->j로 갈 수 있다는 것을 의미한다.
    for(int k = 0; k < N; k++) {
      for(int i = 0; i < N; i++){
        for(int j = 0; j < N; j++){
          if(map[i][k] == 1 && map[k][j] == 1){
            map[i][j] = 1;
          }
        }
      }
    }

    Arrays.stream(map).forEach(i -> System.out.println(Arrays.toString(i)));

  }
}
