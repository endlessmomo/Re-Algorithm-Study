package greedy;

import java.io.*;

public class BOJ_1343_폴리오미노 {

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    String str = in.readLine();
    // replaceAll() 같은 경우 왼쪽에서 오른쪽에서 일치하는 문장을 먼저 찾는다.
    str = str.replaceAll("XXXX", "AAAA");
    str = str.replaceAll("XX", "BB");

    if(str.contains("X")){
      System.out.println(-1);
      return;
    }

    System.out.println(str);
  }
}