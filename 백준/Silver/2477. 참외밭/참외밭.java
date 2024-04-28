import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    int k = Integer.parseInt(br.readLine());

    int[] cnt = new int[5];
    int[] sum = new int[5];

    int[] val = new int[6];

    int mw = 0, wIdx = 0;
    int mh = 0, hIdx = 0;
    for (int i = 0; i < 6; i++) {
      st = new StringTokenizer(br.readLine());
      int idx = Integer.parseInt(st.nextToken());
      val[i] = Integer.parseInt(st.nextToken());

      if(idx < 3) {
        if(mw < val[i]) {
          mw = val[i];
          wIdx = i;
        }
      } else {
        if(mh < val[i]) {
          mh = val[i];
          hIdx = i;
        }
      }
    }

    int total = val[wIdx] * val[hIdx];
    wIdx += 6;
    hIdx += 6;
    int atotal = Math.abs(val[(wIdx - 1) % 6] - val[(wIdx + 1) % 6]) * Math.abs(val[(hIdx - 1) % 6] - val[(hIdx + 1) % 6]);

    System.out.println((total - atotal) * k);

  }

}