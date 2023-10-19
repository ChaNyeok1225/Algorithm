import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	public static void main(String[] args) throws Exception {

		int n = Integer.parseInt(br.readLine());
		
		ArrayList<int[]> line = new ArrayList<>();
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			line.add(new int[] {s,1});
			line.add(new int[] {e,-1});
		}
		
		Collections.sort(line, (a,b) -> a[0] - b[0]);
		
		int l = 0;
		int ans = 0;
		int prev = Integer.MIN_VALUE;
		for(int i = 0; i < line.size(); i++) {
			int[] point = line.get(i);
			if(l > 0)
				ans += point[0] - prev;
			
			l += point[1];
			prev = point[0];
		}
		
		System.out.println(ans);

	}

}