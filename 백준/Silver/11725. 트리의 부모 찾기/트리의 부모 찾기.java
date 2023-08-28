import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;

	
	public static void main(String[] args) throws IOException {
		
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Integer>[] tree = new ArrayList[n+1];
		for(int i = 1;  i< n +1; i++)
			tree[i] = new ArrayList<>();
		
		for(int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a= Integer.parseInt(st.nextToken());
			int b=  Integer.parseInt(st.nextToken());
			
			tree[a].add(b);
			tree[b].add(a);
		}
		
		Queue<Integer> q = new ArrayDeque<Integer>();
		int[] p = new int[n+1];
		
		q.offer(1);
		
		while(!q.isEmpty()) {
			int v = q.poll();
			for(int nxt : tree[v]) {
				if(nxt == p[v]) continue;
				p[nxt] = v;
				q.offer(nxt);
			}
		}
	
		for(int i = 2; i < n + 1; i++)
			sb.append(p[i] + "\n");
		
		System.out.println(sb);
		
		
	}
}
