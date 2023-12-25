package math;

import java.util.HashSet;
import java.util.Set;

public class 문자열_순열 {

    static boolean[] used;
    static char[] chars;
    static Set<String> strings;

    public static boolean sol(String value, String target) {

        strings = new HashSet<>();
        used = new boolean[value.length()];
        chars = value.toCharArray();

        dfs(0, value.length(), "");

        return strings.stream().anyMatch(target::contains);
    }

    public static void dfs(int cnt, int length, String value) {
        if (cnt == length) {
            strings.add(value);
            return;
        }

        for (int i = 0; i < length; i++) {
            if (!used[i]) {
                used[i] = true;
                dfs(cnt + 1, length, value + chars[i]);
                used[i] = false;
            }
        }
    }

    public static boolean sol2(String s1, String s2) {
        final int ALPHABET = 26;

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] cnt = new int[ALPHABET];
        for (int i = 0; i < s1.length(); i++) {
            cnt[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length(); i++) {
            cnt[s2.charAt(i) - 'a']--;

            if (i - s1.length() >= 0) {
                cnt[s2.charAt((i - s1.length()) - 'a')]++;
            }

            boolean isZero = true;
            for (int j = 0; j < ALPHABET; j++) {
                if (cnt[j] != 0) {
                    isZero = false;
                    break;
                }
            }

            if(isZero) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(sol("ab", "acba"));
        System.out.println(sol("ac", "car"));
        System.out.println(sol("ak", "aabbkk"));
    }
}
