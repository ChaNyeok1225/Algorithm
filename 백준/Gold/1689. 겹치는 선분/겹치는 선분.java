import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws Exception {
		
		
		int n = Integer.parseInt(br.readLine());
		
		TreeMap<Integer, Integer> map = new TreeMap<>();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int s= Integer.parseInt(st.nextToken());
			int e= Integer.parseInt(st.nextToken());
			
			map.put(s, map.getOrDefault(s, 0)+1);
			map.put(e, map.getOrDefault(e, 0)-1);
		}
		
		int ans = 0;
		int cnt = 0;
		for(int point : map.keySet()) {
			cnt += map.get(point);
			if(cnt > ans)
				ans = cnt;
		}
		
		System.out.println(ans);
		
	}
	
}