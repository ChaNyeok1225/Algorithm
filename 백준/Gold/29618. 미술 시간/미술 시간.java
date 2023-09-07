import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		TreeSet<Integer> ts = new TreeSet<>();
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] res = new int[n+1];
		for(int i = 1; i < n + 1; i++)
			ts.add(i);
		
		int a, b, x;
		Integer v;
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			
			v = ts.ceiling(a);
			while(v != null && v <= b) {
				res[v] = x;
				ts.remove(v);
				v = ts.ceiling(v);
			}
		}
		
		for(int i = 1; i < n + 1; i++)
			sb.append(res[i]+ " ");
		
		System.out.println(sb);
	}
}