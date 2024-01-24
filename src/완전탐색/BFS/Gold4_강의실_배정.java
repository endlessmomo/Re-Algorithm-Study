package 완전탐색.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Gold4_강의실_배정 {

  static class Course {

    private int start;
    private int end;

    Course(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int N = Integer.parseInt(in.readLine());

    Course[] courses = new Course[N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(in.readLine());
      courses[i] = new Course(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
    }

    Arrays.sort(courses, (c1, c2) -> c1.start == c2.start ? c1.end - c2.end : c1.start - c2.start);

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    pq.offer(courses[0].end);

    for (int i = 1; i < courses.length; i++) {
      if(pq.peek() <= courses[i].start) {
        pq.poll();
      }
      pq.offer(courses[i].end);
    }

    System.out.println(pq.size());
  }
}
