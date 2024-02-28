import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {

  static int answer, len, cnt[];
  static char[] str;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    str = br.readLine().toCharArray();
    len = str.length;
    cnt = new int[26];
    for (int i = 0; i < str.length; i++) {
      cnt[str[i] - 'a']++;
    }

    for (int i = 0; i < 26; i++) {
      if (cnt[i] > 0) {
        cnt[i]--;
        dfs(1, -1, i);
        cnt[i]++;
      }

    }
    System.out.println(answer);
  }

  static void dfs(int idx, int prev, int cur) {
    if (prev == cur) {
      return;
    }
    if (idx == len) {
      answer++;
    }

    for (int i = 0; i < 26; i++) {
      if (cnt[i] > 0) {
        cnt[i]--;
        dfs(idx + 1, cur, i);
        cnt[i]++;
      }
    }
  }

}