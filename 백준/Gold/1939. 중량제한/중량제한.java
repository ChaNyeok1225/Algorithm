import java.io.*;
import java.util.*;

//start	2023. 12. 16  16 : 35
//end	2023. 12. 16  14 : 59
public class Main {

	static int[] p;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		p = new int[n + 1];
		for (int i = 1; i < n + 1; i++) // 크루스칼 parent 배열 초기화
			p[i] = i;

		
		// 크루스칼 pq 간선의 가중치 내림차순 정렬
		PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[2] - a[2]);

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			q.offer(new int[] {from, to, w});
		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		int ans = Integer.MAX_VALUE;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			union(cur[0], cur[1]);
			
			if(find(start) == find(end)) {
				ans = cur[2];
				break;
			}
		}
		System.out.println(ans);
	}
	
	static int find(int a) {
		if(a == p[a]) return a;
		return p[a] = find(p[a]);
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if(a == b)
			return;
		
		p[b] = a;
	}
	
}