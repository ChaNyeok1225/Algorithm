import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int r = Integer.parseInt(st.nextToken()) - 1;
    int c = Integer.parseInt(st.nextToken()) - 1;
    int k = Integer.parseInt(st.nextToken());

    int[][] arr = new int[100][100];

    for(int i = 0; i < 3; i++) {
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < 3; j++){
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    int rl = 3, cl = 3;
    int[] count = new int[101];

    PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
      if(a[1] == b[1]) {
        return a[0] - b[0];
      }
      return a[1] - b[1];
    });

    int time = -1;
    for(int t = 0; t < 101; t++) {
      pq.clear();

      if(arr[r][c] == k) {
        time = t;
        break;
      }
      if(rl >= cl) {
        for(int i = 0; i < rl; i++) {

          for(int j = 0; j < cl; j++) {
            count[arr[i][j]]++;
            arr[i][j] = 0;
          }

          for(int j = 1; j < 101; j++) {
            if(count[j] > 0) {
              pq.offer(new int[] {j, count[j]});
              count[j] = 0;
            }
          }

          for(int j = 0; j < 100 && !pq.isEmpty(); j+=2) {
            int[] cur = pq.poll();

            arr[i][j] = cur[0];
            arr[i][j+1] = cur[1];

            cl = cl > j+2 ? cl : j+2;
          }
        }
      } else {

        for(int i = 0; i < cl; i++) {

          for(int j = 0; j < rl; j++) {
            count[arr[j][i]]++;
            arr[j][i] = 0;
          }

          for(int j = 1; j < 101; j++) {
            if(count[j] > 0) {
              pq.offer(new int[] {j, count[j]});
              count[j] = 0;
            }
          }

          for(int j = 0; j < 100 && !pq.isEmpty(); j+=2) {
            int[] cur = pq.poll();

            arr[j][i] = cur[0];
            arr[j+1][i] = cur[1];

            rl = rl > j+2 ? rl : j+2;
          }
        }
      }

    }

    System.out.println(time);

  }

}