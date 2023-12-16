//start	2023. 12. 16  18 : 18
//end	2023. 12. 16  18 : 38
import java.io.*;
import java.util.*;

public class Main {
	
	static class Data implements Comparable<Data>{ 
		int idx;
		long w;
		
		Data(int idx, long w) {
			this.idx = idx;
			this.w = w;
		}
		
		public int compareTo(Data o) {
			return Long.compare(this.w, o.w);
		}
	}
	
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        boolean[] vision = new boolean[n];
        
        st = new StringTokenizer(br.readLine());
        List<int[]>[] graph = new ArrayList[n];
        for(int i = 0;  i < n; i++) {
        	graph[i] = new ArrayList<int[]>();
        	int a = Integer.parseInt(st.nextToken());
        	vision[i] = a == 1 ? true : false;
        } vision[n-1] = false;
        
        
        for(int i = 0 ; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int from= Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	int w = Integer.parseInt(st.nextToken());
        	
        	if(vision[from] || vision[to])
        		continue;
        	
        	graph[from].add(new int[] {to, w});
        	graph[to].add(new int[] {from, w});
        }
        
        boolean[] vis = new boolean[n];
        long[] minEdge = new long[n];
        
        long INF = 11_000_000_000L;
        
        Arrays.fill(minEdge, INF);
        minEdge[0] = 0;
        
        PriorityQueue<Data> q = new PriorityQueue<>();
        q.offer(new Data(0, minEdge[0]));
        int cnt = 0;
        
        while(!q.isEmpty()) {
        	Data cur = q.poll();
        	
        	if(vis[cur.idx]) continue;
        	
        	vis[cur.idx] = true;
        	cnt++;
        	if(cnt == n)
        		break;
        	
        	for(int[] nxt : graph[cur.idx]) {
        		if(minEdge[nxt[0]] <= cur.w + nxt[1]) continue;
        		minEdge[nxt[0]] = cur.w + nxt[1];
        		q.offer(new Data(nxt[0], minEdge[nxt[0]]));
        	}
        }
        
        if(minEdge[n-1] == INF)
        	minEdge[n-1] = -1;
        System.out.println(minEdge[n-1]);
        
    }
}