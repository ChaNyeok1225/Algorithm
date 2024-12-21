import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    int[] arr = new int[N];
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int[] count = new int[100_001];
    int e = 0, ans = 0;
    for(int s = 0; s < N; s++)  {
      while(e < N && count[arr[e]] < K) {
        count[arr[e]]++;
        e++;
        ans = Math.max(ans, e-s);
      }
      count[arr[s]]--;
    }
    System.out.println(ans);

  }

}