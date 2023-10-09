import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {

			char[] a = br.readLine().toCharArray();
			char[] w = br.readLine().toCharArray();
			char[] s = br.readLine().toCharArray();
			
			HashMap<Integer, Character> map = new HashMap<>();
			HashMap<Character, Integer> rmap = new HashMap<>();
			
			for(int i = 0; i < a.length; i++) {
				map.put(i, a[i]);
				rmap.put(a[i], i);
			}
			
			
			int[] f = new int[w.length];
			
			int j = 0;
			for(int i = 1; i < w.length; i++) {
				while(j > 0 && w[i] != w[j]) j = f[j-1];
				if(w[i] == w[j]) f[i] = ++j; 
			}
			
			
			List<Integer> list = new ArrayList<Integer>();
			int mod = a.length;
			for(int x = 0; x < a.length; x++) {				
				j = 0;
				
				int cnt = 0;
				for(int i = 0; i < s.length; i++) {

					while(j > 0 && s[i] != w[j]) j = f[j-1];
					if(s[i] == w[j]) ++j;
					if(j == w.length) {
						cnt++;
						j = f[j-1];
					}
				}
				
				if(cnt == 1)
					list.add(x);
				
				for(int i = 0; i < w.length; i++) {
					w[i] = map.get((rmap.get(w[i]) + 1) % mod);
				}
			}
			
			if(list.size() == 0)
				sb.append("no solution");
			else if(list.size() == 1)
				sb.append("unique: " + list.get(0));
			else {
				sb.append("ambiguous: ");
				for(int i = 0; i < list.size(); i++)
					sb.append(list.get(i)).append(" ");
			}

			sb.append("\n");
		}
		
		System.out.print(sb);
	}

}