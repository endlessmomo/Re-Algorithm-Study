package softier.lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 문제 정리
* 슈퍼바이러스 K마리가 있다면 N초 후 총 몇마리가 되는지
* 슈퍼바이러스 K마리는 * 0.1초당 P배 증가한다.
* 수식 : K * (P)^10N
* 1차 시도 -> 단순 연산을 통해 진행 (실패 - 시간적 에러)
* */
public class 슈퍼바이러스 {

    static final int MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        long K = Long.parseLong(st.nextToken());
        long P = Long.parseLong(st.nextToken());
        long N = Long.parseLong(st.nextToken()) * 10;
        long times = 1;

        /* 첫번째 시도 --> 시간 초 에러 발생
        while (N-- > 0) {
            times *= P;
            times %= MOD;
        }
        System.out.println(K * times);
        */
    }
}
