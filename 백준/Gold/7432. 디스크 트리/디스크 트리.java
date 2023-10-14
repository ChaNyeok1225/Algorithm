import java.io.*;
import java.util.*;

public class Main {

	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	

	public static void main(String[] args) throws Exception {
		
		int n = Integer.parseInt(br.readLine());
		
		TreeMap<String, Object> tm = new TreeMap<>();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), "\\");
			
			TreeMap tree = tm;
			while(st.hasMoreTokens()) {
				String str = st.nextToken();
				if(!tree.containsKey(str))
					tree.put(str, new TreeMap<String,Object>());
				tree = (TreeMap) tree.get(str);
			}
		}
		
		print(0, tm);
		
		System.out.println(sb);
	}
	
	static void print(int depth, TreeMap<String, Object> tree) {
		for(String key : tree.keySet()) {
			for(int i = 0; i < depth; i++)
				sb.append(" ");
			sb.append(key).append("\n");
			print(depth+1, (TreeMap) tree.get(key));
		}
	}
}