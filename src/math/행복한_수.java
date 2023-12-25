package math;

import java.util.HashSet;
import java.util.Set;

public class 행복한_수 {

    public static boolean sol(int val) {
        Set<Integer> sequence = new HashSet<>();

        while (sequence.add(val)) {
            int n = 0;

            while (val > 0) {
                int remain = val % 10;
                n += remain * remain;
                val /= 10;
            }

            if (n == 1 ){
                return true;
            }

            val = n;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(sol(19));
        System.out.println(sol(2));
        System.out.println(sol(61));
    }
}
