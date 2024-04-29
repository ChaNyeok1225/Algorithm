import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.BitSet;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int answer = 0;
    StringBuilder s = new StringBuilder(br.readLine());
    StringBuilder t = new StringBuilder(br.readLine());
    int sl = s.length();
    int tl = t.length();

    while(sl < tl) {
      char c = t.charAt(tl-1);

      if(c == 'A') {
        t.setLength(tl-1);
      } else if (c == 'B') {
        t.setLength(tl-1);
        t.reverse();
      } else {
        break;
      }
      tl--;
    }

    if(s.toString().contentEquals(t))
      answer = 1;

    System.out.println(answer);
  }

}