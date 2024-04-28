import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int h = Integer.parseInt(st.nextToken());
    int w = Integer.parseInt(st.nextToken());

    ArrayDeque<Integer> q = new ArrayDeque<>();

    st = new StringTokenizer(br.readLine());

    int mh = 0;
    int answer = 0;
    for(int i = 0; i < w; i++) {
      int block = Integer.parseInt(st.nextToken());

      if(!q.isEmpty() && q.peekFirst() <= block) {
        int f = q.pollFirst();
        while(!q.isEmpty()) {
          answer += f - q.pollFirst();
        }
      }
      q.offer(block);
    }

    ArrayDeque<Integer> tq = new ArrayDeque<>();
    while(!q.isEmpty()) {
      int block = q.pollLast();

      if(!tq.isEmpty() && tq.peekFirst() <= block) {
        int f = tq.pollFirst();
        while(!tq.isEmpty()) {
          answer += f - tq.pollFirst();
        }
      }
      tq.offer(block);
    }

    System.out.println(answer);
  }

}