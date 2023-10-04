import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws Exception {
		
		String t = br.readLine();
		String p = br.readLine();
		int[][] dfa = new int[53][p.length()];
		
		dfa[convert(p.charAt(0))][0] = 1;
		int X = 0;
		for(int j = 1; j < p.length(); j++) {
			for(int c = 0; c < 53; c++)
				dfa[c][j] = dfa[c][X];
			int alpha = convert(p.charAt(j));
			dfa[alpha][j] = j + 1;
			X = dfa[alpha][X];
		}
		
		int idx = 0, cnt = 0;
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0; i < t.length(); i++) {
			idx = dfa[convert(t.charAt(i))][idx];
			if(idx == p.length()) {
				cnt++;
				list.add(i - p.length() + 2);
				idx = X;
			}
		}
		
		System.out.println(cnt);
		for(int val : list)
			sb.append(val).append(" ");
		System.out.print(sb);
		
	}
	
	static int convert(char c) {
		if(Character.isUpperCase(c))
			return c - 'A' + 1;
		else if(Character.isLowerCase(c))
			return c - 'a' + 27;
		else
			return 0;
	}
	
}