import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[N];
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    int S = Integer.parseInt(br.readLine());
    int step = 0;
    while(step < N) {
      int num = arr[step], idx = -1;

      for(int i = step; i < N; i++) {
        if(num < arr[i] && i - step <= S) {
          num = arr[i];
          idx = i;
        }
      }

      if(idx != -1) {
        int tmp = arr[idx];
        for (int i = idx; i > step; i--) {
          arr[i] = arr[i - 1];
        }
        arr[step] = tmp;
        S -= (idx - step) ;
      }
      step++;
    }

    for(int i = 0; i < N; i++)
      sb.append(arr[i]).append(" ");
    System.out.println(sb);
  }

}