package softier.HSAT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Min_Coin {
    // 유형 A 여러개 사용가능
    // 유형 B 한개만 사용가능

    static int[] aType, bType;
    static int n, target;
    static int[] dp;
    static Coin[] coins;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        n = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        coins = new Coin[n];
        dp = new int[target + 1];
        Arrays.fill(dp, 10001);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(in.readLine());
            coins[i] = new Coin(st.nextToken(), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(coins);

        for (Coin coin : coins) {
            int val = coin.value;
            dp[val] = 1;

            if (coin.type.equals("B")) {

                boolean[] created = new boolean[target + 1];
                for (int i = val + 1; i + val <= target; i++) {
                    if (dp[i] != 10001 && !created[i]) {
                        if (dp[i + val] == 10001)
                            created[i + val] = true;
                        dp[i + val] = Math.min(dp[i + val], dp[i] + 1);
                    }
                }
            } else {
                for (int i = val + 1; i <= target; i++) {
                    if (dp[i - val] != 10001 || i % val == 0) {
                        dp[i] = Math.min(dp[i], dp[i - val] + 1);
                    }
                }
            }
        }

        System.out.println(Arrays.toString(dp));
        System.out.println(dp[target] == 10001 ? -1 : dp[target]);
    }

    static class Coin implements Comparable<Coin> {
        String type;
        int value;

        private Coin() {
        }

        public Coin(String type, int value) {
            this.type = type;
            this.value = value;
        }

        @Override
        public int compareTo(Coin o) {
            if (!o.type.equals(this.type)) {
                return o.type.compareTo(this.type);
            }

            return o.value - this.value;
        }

        @Override
        public String toString() {
            return "Coin{" +
                    "type='" + type + '\'' +
                    ", value=" + value +
                    '}';
        }
    }
}