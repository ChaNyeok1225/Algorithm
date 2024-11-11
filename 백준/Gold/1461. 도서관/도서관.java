import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    int[] np = new int[n];
    int[] pp = new int[n];
    st = new StringTokenizer(br.readLine());
    int num, pi = 0, ni = 0;
    for (int i = 0; i < n; i++) {
      num = Integer.parseInt(st.nextToken());
      if(num > 0) {
        pp[pi++] = num;
      } else {
        np[ni++] = -num;
      }
    }
    Arrays.sort(pp);
    Arrays.sort(np);

    int answer = 0;
    for(int i = n - 1; i >= 0; i -= m) {
      answer += pp[i] * 2;
      answer += np[i] * 2;
    }

    int end = pp[n-1] > np[n-1] ? pp[n-1] : np[n-1];
    System.out.println(answer - end);
  }
}