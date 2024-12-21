import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());
    int[] A = new int[N];
    int[] count = new int[60001];
    Arrays.fill(A, Integer.MAX_VALUE);

    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }

    long ans = 0;
    for(int i = 0; i < N; i++) {
      ans += count[30000 - A[i]];
      for(int j = 0; j < i; j++) {
        count[30000 + A[i] + A[j]]++;
      }
    }

    System.out.println(ans);
  }

}