import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] juwels = new int[n][2];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			juwels[i][0] = m;
			juwels[i][1] = v;
		}
		Arrays.sort(juwels, (a,b) -> b[1]-a[1]);
		
		
		TreeMap<Integer,Integer> c = new TreeMap<>();
		for(int i = 0; i < k; i++) {
			int x = Integer.parseInt(br.readLine());
			c.put(x, c.getOrDefault(x, 0) + 1);
		}
		
		long total = 0;
		int idx = 0;
		while(idx < n && !c.isEmpty()) {
			int[] juwel = juwels[idx++];
			
			Integer key = c.higherKey(juwel[0]-1);
			if(key == null)
				continue;
			
			total+=juwel[1];
			int cnt = c.get(key);
			cnt--;
			
			if(cnt==0)
				c.remove(key);
			else
				c.put(key,cnt);
		}
		
		System.out.println(total);
		
	}

}
