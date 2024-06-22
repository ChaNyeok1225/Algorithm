import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;
    int answer = 0;

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];

    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);

    int r;
    for(int i = 0; i < n; i++) {
      r = n-1;
      for(int l = 0; l < r; l++) {
        if(i == l) continue;

        while(i == r || (r >= 0 && arr[i] < arr[l] + arr[r])) {
          r--;
        }
        if(r >= 0 && l != r && arr[i] == arr[l] + arr[r]) {
          answer++;
          break;
        }
      }
    }
    System.out.println(answer);

  }
}