import java.util.*;
import java.io.*;

public class Main {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());
    char[] S = br.readLine().toCharArray();

    int size = 2*N+1;
    char[] search = new char[size];
    char[] ch = {'I', 'O'};
    int sel = 0;
    for(int i = 0; i < size; i++) {
      search[i] = ch[sel];
      sel ^= 1;
    }

    int[] d = new int[size];
    int j = 0;
    for(int i = 1; i < size; i++) {
      while(j > 0 && search[i] != search[j]) j = d[j - 1];
      if(search[i] == search[j]) d[i] = ++j;
    }

    int cnt = 0;
    j = 0;
    for(int i = 0; i < M; i++) {
      while(j > 0 && S[i] != search[j]) j = d[j - 1];
      if(S[i] == search[j]) ++j;
      if(j == size) {
        cnt++;
        j = d[j - 1];
      }
    }

    System.out.println(cnt);
  }

}