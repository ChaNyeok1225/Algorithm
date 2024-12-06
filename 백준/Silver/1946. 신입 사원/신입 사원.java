import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    int T = Integer.parseInt(br.readLine());


    while(T-- > 0) {
      int n = Integer.parseInt(br.readLine());
      int[][] score = new int[n][2];
      for(int i = 0; i < n; i++) {
        st = new StringTokenizer(br.readLine());
        score[i][0] = Integer.parseInt(st.nextToken());
        score[i][1] = Integer.parseInt(st.nextToken());
      }
      Arrays.sort(score, (a,b) ->
          a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]
      );

      int cur = 100_000, cnt = 0;
      for(int i = 0; i < n; i++) {
        if(score[i][1] > cur) continue;
        cnt++;
        cur = cur < score[i][1] ? cur : score[i][1];
      }
      sb.append(cnt).append("\n");
    }

    System.out.print(sb);
  }
}