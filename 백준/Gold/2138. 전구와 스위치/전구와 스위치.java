import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    char[] state = br.readLine().toCharArray();
    char[] target = br.readLine().toCharArray();

    int ans = Integer.MAX_VALUE, cnt;
    char[] tmp = new char[n + 1];

    cnt = 0;
    for(int i = 0; i < state.length; i++)
      tmp[i] = state[i];

    for(int i = 0; i < n - 1; i++) {
      if(tmp[i] == target[i]) continue;
      toggle(tmp, i + 1);
      cnt++;
    }

    for(int i = 0; i < n; i++) {
      if(tmp[i] != target[i]) break;
      if(i == n - 1)
        ans = ans < cnt ? ans : cnt;
    }

    cnt = 1;
    for(int i = 0; i < state.length; i++)
      tmp[i] = state[i];
    tmp[0] = tmp[0] == '0' ? '1' : '0';
    tmp[1] = tmp[1] == '0' ? '1' : '0';

    for(int i = 0; i < n - 1; i++) {
      if(tmp[i] == target[i]) continue;
      toggle(tmp, i + 1);
      cnt++;
    }

    for(int i = 0; i < n; i++) {
      if(tmp[i] != target[i]) break;
      if(i == n - 1)
        ans = ans < cnt ? ans : cnt;
    }

    if(ans == Integer.MAX_VALUE)
      ans = -1;
    System.out.println(ans);
  }

  static void toggle(char[] arr, int index) {
    arr[index - 1] = arr[index - 1] == '0' ? '1' : '0';
    arr[index] = arr[index] == '0' ? '1' : '0';
    arr[index + 1] = arr[index + 1] == '0' ? '1' : '0';
  }
}