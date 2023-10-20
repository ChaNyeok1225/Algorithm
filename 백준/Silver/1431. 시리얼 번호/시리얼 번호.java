import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		
		String[] sn = new String[n];
		
		for(int i = 0; i < n; i++) {
			sn[i] = br.readLine();
		}
		
		Arrays.sort(sn, (s1, s2) -> {
			if(s1.length() == s2.length()) {
				int v1 = 0;
				int v2 = 0;
				
				for(int i = 0; i < s1.length(); i++) {
					if(Character.isDigit(s1.charAt(i)))
						v1 += s1.charAt(i) - '0';
					if(Character.isDigit(s2.charAt(i)))
						v2 += s2.charAt(i) - '0';
					
				}
				
				if(v1 == v2)
					return s1.compareTo(s2);
				return v1 - v2;
				
			}
			return s1.length() - s2.length();
		});
		
		for(int i = 0; i < n; i++)
			sb.append(sn[i]).append("\n");
		
		System.out.print(sb);
	}
	
}