import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	static int[] p;
	
	public static void main(String[] args) throws IOException {

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		p = new int[n];
		for(int i = 0; i < n; i++)
			p[i] = i;
		
		int res = 0;
		for(int i = 1; i < m+1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(!union(a,b) && res == 0) {
				res = i;
			}
		}
		System.out.println(res);
		
	}
	
	static boolean union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a==b)
			return false;
		
		p[b] = a;
		return true;
	}
	
	static int find(int a) {
		if(a==p[a]) return a;
		return p[a] = find(p[a]);
	}
	
}