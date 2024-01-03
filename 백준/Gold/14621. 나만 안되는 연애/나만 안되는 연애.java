import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        boolean[] gen = new boolean[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < n+1; i++)
        	gen[i] = st.nextToken().equals("M") ? true : false;
        
        List<int[]>[] graph = new ArrayList[n+1];
        for(int i = 1; i < n + 1; i++)
        	graph[i] = new ArrayList<>();
        
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	int w = Integer.parseInt(st.nextToken());
        	
        	graph[from].add(new int[] {to, w});
        	graph[to].add(new int[] {from, w});
        }
        
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[1] - b[1] );
        
        boolean[] vis = new boolean[n+1];
        int cnt = 0, ans = 0;;
        int[] minEdge = new int[n+1];
        Arrays.fill(minEdge, Integer.MAX_VALUE);
        minEdge[1] = 0;
        q.offer(new int[] {1, minEdge[1]});
        
        while(!q.isEmpty()) {
        	int[] cur = q.poll();
        	
        	if(vis[cur[0]]) continue;
        	vis[cur[0]] = true;
        	cnt++;
        	ans += cur[1];
        	if(cnt==n)
        		break;
        	
        	for(int[] nxt : graph[cur[0]]) {
        		if(gen[nxt[0]] == gen[cur[0]]) continue;
        		if(minEdge[nxt[0]] <= nxt[1]) continue;
        		minEdge[nxt[0]] = nxt[1];
        		q.offer(new int[] {nxt[0], minEdge[nxt[0]]});
        	}
        }
        
        if(cnt == n)
        	System.out.println(ans);
        else
        	System.out.println(-1);
        
    }
}