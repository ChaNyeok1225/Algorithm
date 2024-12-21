import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    int T  = Integer.parseInt(br.readLine());
    while(T-- > 0) {
      int N = Integer.parseInt(br.readLine());
      int[] L = new int[N];
      st = new StringTokenizer(br.readLine());
      for(int i = 0; i < N; i++) {
        L[i] = Integer.parseInt(st.nextToken());
      }

      int ans = 0;
      Arrays.sort(L);
      for(int i = N-3; i >= 0; i--) {
        ans = ans > L[i+2] - L[i] ? ans : L[i+2] - L[i];
      }

      sb.append(ans).append("\n");
    }

    System.out.print(sb);
  }

}