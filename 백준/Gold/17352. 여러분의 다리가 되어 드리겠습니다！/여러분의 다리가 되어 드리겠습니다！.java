import java.io.*;
import java.util.*;

public class Main {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		
		int n = Integer.parseInt(br.readLine());
		
		int[] p = new int[n+1];
		
		for(int i = 1; i <= n; i++)
			p[i] = i;
		
		
		for(int i = 0 ; i < n - 2; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			union(p, a, b);
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = i+1; j <= n; j++) {
				if(find(p,i) != find(p, j)) {
					System.out.println(i+" "+j);
					return;
				}
			}
		}
		
	}
	
	private static int find(int[] p, int a) {
		if(p[a] == a) return a;
		return p[a] = find(p, p[a]);
	}
	
	private static void union(int[] p, int a, int b) {
		a = find(p, a);
		b = find(p, b);
		
		if(a == b) {
			return;
		}
		
		p[b] = a;
	}
	
}