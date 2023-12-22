package math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 파스칼정리 {

    public static List<List<Integer>> sol(int row) {

        List<List<Integer>> result = new ArrayList<>();

        // O(N^2)
        for (int i = 0; i < row; i++) {
            List<Integer> list = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    int x = result.get(i - 1).get(j - 1);
                    int y = result.get(i - 1).get(j);
                    list.add(x + y);
                }
            }
            result.add(list);
        }
        return Collections.unmodifiableList(result);
    }

    public static void main(String[] args) {
        // Test Code
        System.out.println(sol(1));
        System.out.println(sol(2));
        System.out.println(sol(3));
        System.out.println(sol(4));
        System.out.println(sol(5));
    }
}
