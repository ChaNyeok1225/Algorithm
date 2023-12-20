import java.io.*;
import java.util.*;

// start	2023. 12. 20  13 : 50
// end 		2023. 12. 20  13 : 56
public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        List<int[]>[] graph = new ArrayList[n+1];
        for(int i = 1; i < n + 1; i++)
        	graph[i] = new ArrayList<int[]>();
        
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	int w = Integer.parseInt(st.nextToken());
        	
        	graph[from].add(new int[] {to, w});
        	graph[to].add(new int[] {from,w});
        }
        
        int[] minEdge = new int[n+1];
        Arrays.fill(minEdge, Integer.MAX_VALUE);
        minEdge[1] = 0;
        boolean[] vis = new boolean[n+1];
        int cnt = 0;
        int ans = 0;
        
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        q.offer(new int[] {1, minEdge[1]});
        
        while(!q.isEmpty()) {
        	int[] cur = q.poll();
        	
        	if(vis[cur[0]]) continue;
        	
        	vis[cur[0]] = true;
        	cnt++;
        	ans += cur[1];
        	if(cnt == n)
        		break;
        	
        	for(int[] nxt : graph[cur[0]]) {
        		if(minEdge[nxt[0]] <= nxt[1]) continue;
        		minEdge[nxt[0]] = nxt[1];
        		q.offer(new int[] {nxt[0], minEdge[nxt[0]]});
        	}
        }
        
        System.out.println(ans);
        
    }
}