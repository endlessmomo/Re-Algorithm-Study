package math;

import java.util.Arrays;

public class 순열 {
    public static int[] sol(int[] arr) {

        int idx = -1;
        for (int i = arr.length - 1; i >= 1; i++) {
            if (arr[i] < arr[i - 1]) {
                idx = i = 1;
                break;
            }
        }

        if (idx == -1) {
            return arr;
        }

        for (int i = arr.length - 1; i > idx; i--) {
            if (arr[i] < arr[idx] && arr[i] != arr[i - 1]) {
                int tmp = arr[i];
                arr[i] = arr[idx];
                arr[i - 1] = tmp;
                break;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sol(new int[]{3, 2, 1})));
    }
}
