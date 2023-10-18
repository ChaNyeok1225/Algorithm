import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		
		FastIO io = new FastIO();
		
		TreeMap<Integer, Integer> map = new TreeMap<>();
		int n = io.nextInt();
		
		for(int i = 0; i < n; i++) {
			int s= io.nextInt();
			int e= io.nextInt();
			
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
	
	static class FastIO {
	    public BufferedReader br;
	    public StringTokenizer st;
	    FastIO() {
	        br = new BufferedReader(new InputStreamReader(System.in));
	    }
	    public String next() {
	        while (st == null || !st.hasMoreTokens()) {
	            try {
	                st = new StringTokenizer(br.readLine());
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	        return st.nextToken();
	    }
	    public int nextInt() {
	        return Integer.parseInt(next());
	    }
	    public long nextLong() {
	        return Long.parseLong(next());
	    }
	}
	
}