import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Main {
  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;
    int answer = Integer.MAX_VALUE;

    st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int[] arr = new int[n];
    int l = 0, r = 0, mid;

    for(int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
      l = l > arr[i] ? l : arr[i];
      r += arr[i];
    }

    int k, sum;
    while(l <= r) {
      mid = l + (r - l) / 2;
      k = 1;
      sum = 0;
      for(int i = 0; i < n; i++) {
        if(sum + arr[i] <= mid) {
          sum += arr[i];
        } else {
          sum = arr[i];
          k++;
        }
      }

      if(k <= m) {
        answer = mid;
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }

    System.out.println(answer);

  }
}