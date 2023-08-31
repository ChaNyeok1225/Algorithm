import java.io.*;
import java.util.*;

public class Main {
	
	static ArrayList<Integer>[] tree;
	static int[] childCnt;
	static boolean[] vis;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());
		
		tree = new ArrayList[n+1];
		for(int i = 1; i<n+1; i++)
			tree[i] = new ArrayList<>();
		
		childCnt = new int[n+1];
		vis = new boolean[n+1];
		
		for(int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int f = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			tree[f].add(t);
			tree[t].add(f);
		}
		
		vis[r] = true;
		child(r);
		
		for(int i = 0; i < q; i++) {
			int v = Integer.parseInt(br.readLine());
			sb.append(childCnt[v] + 1 + "\n");
		}
		System.out.println(sb);

	}
	
	static int child(int v) {
		
		int child = 0;
		int cnt = 0;
		for(int nv : tree[v]) {
			if(vis[nv]) continue;
			vis[nv] = true;
			child += child(nv);
			cnt++;
		}
		
		return childCnt[v] = cnt + child;
	}
}