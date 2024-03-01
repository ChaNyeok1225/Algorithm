import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    StringTokenizer st;

    char[] str = br.readLine().toCharArray();
    char[] target = br.readLine().toCharArray();

    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < str.length; i++) {
      stack.add(str[i]);

      if (stack.size() >= target.length) {
        boolean flag = true;

        for (int j = 0; j < target.length; j++) {
          if (stack.get(stack.size() - target.length + j) != target[j]) {
            flag = false;
            break;
          }
        }

        if (flag) {
          for (int j = 0; j < target.length; j++) {
            stack.pop();
          }
        }
      }
    }

    if (stack.isEmpty()) {
      System.out.println("FRULA");
    } else {
      for (Character c : stack) {
        sb.append(c);
      }
      System.out.println(sb);
    }
  }
}