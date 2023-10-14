import java.io.*;
import java.util.*;

public class Main {
	
	static class Trie {
		Trie[] nxt = new Trie[26];
		boolean use;
		int cnt;
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		
		Trie root = new Trie();
		
		for(int i = 0; i < n; i++) {
			char[] c = br.readLine().toCharArray();
			boolean saveFlag = false;
			Trie t = root;
			for(int j = 0; j < c.length; j++) {
				if(!saveFlag)
					sb.append(c[j]);
				if(t.nxt[c[j]-'a'] == null) {
					t.nxt[c[j]-'a'] = new Trie();
					saveFlag = true;
				}
				t = t.nxt[c[j]-'a'];
			}
			
			if(!saveFlag) {
				if(t.cnt > 0)
					sb.append(t.cnt+1);
			}
			t.cnt++;
			sb.append("\n");
		}
		
		System.out.print(sb);
	}
	
}