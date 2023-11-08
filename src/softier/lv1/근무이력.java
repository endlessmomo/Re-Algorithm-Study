package softier.lv1;

import java.io.*;
import java.util.*;
public class 근무이력 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int total = 0;

        for(int i = 0; i < 5; i++){
            st = new StringTokenizer(in.readLine(), " ");

            total += timeCal(changeToMinute(st.nextToken()), changeToMinute(st.nextToken()));
        }

        System.out.println(total);
    }

    public static int timeCal(int start, int end){
        return end - start;
    }

    public static int changeToMinute(String time){
        // hours = times[0], minute = times[1];
        String[] times = time.split(":");
        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }
}
