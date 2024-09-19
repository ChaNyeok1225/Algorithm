import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    HashMap<Character, Integer> mapping = new HashMap<>();
    int idx = 0;
    for(int i = 0; i < 10; i++)
      mapping.put((char)(i + '0'), idx++);
    for(int i = 0; i < 26; i++) {
      mapping.put((char)(i + 'A'), idx++);
      mapping.put((char)(i + 'a'), idx++);
    }

    int n = Integer.parseInt(br.readLine());

    PriorityQueue<String[]> pq = new PriorityQueue<>((a,b) -> {
      int min = a.length < b.length ? a.length : b.length;
      for(int i = 0; i < min; i++) {
        if(a[i].equals(b[i])) continue;
        if(Character.isDigit(a[i].charAt(0)) && Character.isDigit(b[i].charAt(0))) {
          int comp =  new BigInteger(a[i]).compareTo(new BigInteger(b[i]));
          if(comp == 0)
            return a[i].length() - b[i].length();
          return comp;
        } else {
          int emin = a[i].length() < b[i].length() ? a[i].length() : b[i].length();
          for(int j = 0; j < emin; j++) {
            int comp = mapping.get(a[i].charAt(j)) - mapping.get(b[i].charAt(j));
            if(comp == 0)
              continue;
            return comp;
          }
          return a[i].length() - b[i].length();
        }
      }
      return a.length - b.length;
    });

    char[] ch;
    boolean numflag;
    ArrayList<String> list = new ArrayList<>();
    for(int i = 0; i < n; i++) {
      ch = br.readLine().toCharArray();
      numflag = Character.isDigit(ch[0]);

      for(int j = 0; j < ch.length; j++) {
        if(Character.isDigit(ch[j]) != numflag) {
          list.add(sb.toString());
          sb.setLength(0);
        }
        sb.append(ch[j]);
        numflag = Character.isDigit(ch[j]);
      }
      list.add(sb.toString());
      sb.setLength(0);
      pq.offer(list.toArray(new String[0]));
      list.clear();
    }

    while(!pq.isEmpty()) {
      for(String str : pq.poll())
        sb.append(str);
      sb.append("\n");
    }
    System.out.print(sb);

  }
}