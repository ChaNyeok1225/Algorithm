import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static TreeMap<String, Object> map = new TreeMap<>();
	
	public static void main(String[] args) throws IOException {
		
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++ ) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			
			TreeMap<String, Object> tm = map;
			for(int j = 0; j < k; j++) {
				String str = st.nextToken();
				if(!tm.containsKey(str)) {
					tm.put(str, new TreeMap<String, Object>());
				}
				
				tm = (TreeMap) tm.get(str);
			}
		}
		
		for(String s : map.keySet()) {
			print((TreeMap)map.get(s), s, 0);
		}
		
		System.out.print(sb);
	}
	
	
	static void print(TreeMap<String, Object> tm, String key, int depth) {
		
		for(int i = 0; i < depth; i++)
			sb.append("--");
		sb.append(key).append("\n");
		
		for(String s : tm.keySet()) {
			print((TreeMap)tm.get(s), s, depth+1);
		}
	}
	
}