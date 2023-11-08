package softier.lv1;

import java.io.*;
import java.util.*;

public class A플러스B {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(in.readLine());
            int sum = parseInt(st.nextToken()) + parseInt(st.nextToken());

            sb.append("Case #").append(i + ": ").append(sum).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int parseInt(String num) {
        return Integer.parseInt(num);
    }
}
