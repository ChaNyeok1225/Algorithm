import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		TreeSet<String> set = new TreeSet<>();
		
		char[] c = br.readLine().toCharArray();
		
		for(int i = c.length-1; i >= 0; i--) {
			sb.insert(0, c[i]);
			set.add(sb.toString());
		}
		
		sb.setLength(0);
		for(String s : set)
			sb.append(s).append("\n");
		
		System.out.print(sb);
		
	}
	
}