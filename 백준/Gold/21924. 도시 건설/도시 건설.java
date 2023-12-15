import java.io.*;
import java.util.*;

//start	2023. 12. 15  14 : 10
//end	2023. 12. 15  14 : 23
public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		List<int[]>[] graph = new ArrayList[n+1]; // 인접 리스트 초기화
		for(int i = 1; i < n+1; i++)
			graph[i] = new ArrayList<int[]>();
		
		long total = 0; // 모든 도로 건설 했을 때 비용
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			// 양방향 리스트 초기화
			graph[from].add(new int[] {to, w}); 
			graph[to].add(new int[] {from , w});
			total += w;
		}

		// Prim
		PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		int[] minEdge = new int[n+1]; 
		boolean[] vis = new boolean[n+1];
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		
		minEdge[1] = 0;
		int cnt = 0;
		long sum = 0;
		q.offer(new int[] {1, minEdge[1]});
		
		while(!q.isEmpty()) {
			
			int[] cur = q.poll();
			
			if(vis[cur[0]])
				continue;
			
			vis[cur[0]] = true;
			sum += cur[1];
			cnt++;
			
			if(cnt == n)
				break;
			
			for(int[] nxt : graph[cur[0]]) {
				if(minEdge[nxt[0]] <= nxt[1]) continue;
				minEdge[nxt[0]] = nxt[1];
				q.offer(new int[] {nxt[0], minEdge[nxt[0]]});
			}
		}
		
		long ans = -1;
		
		if(cnt == n)
			ans = total - sum;
		
		System.out.println(ans);
		
		
		
	}
}