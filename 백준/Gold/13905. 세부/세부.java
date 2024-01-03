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
        
        int[] p = new int[n+1];
        for(int i = 1; i < n + 1; i++)
        	p[i] = i;
        
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        
        PriorityQueue<int[]> edges = new PriorityQueue<>((a,b) -> b[2] - a[2] );
        for(int i = 0; i < m; i++) {
        	st = new StringTokenizer(br.readLine());
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	int w = Integer.parseInt(st.nextToken());
        	
        	edges.offer(new int[] {from, to, w});
        }
        
        int ans = 0;
        while(!edges.isEmpty()) {
        	int[] cur = edges.poll();
        	
        	union(cur[0], cur[1], p);
        	if(find(s, p) == find(e, p)) {
        		ans = cur[2];
        		break;
        	}
        }
        
        System.out.println(ans);
    }
    
    
    static int find(int a, int[] p) {
    	if(p[a] == a) return a;
    	return p[a] = find(p[a], p);
    }
    
    static void union(int a, int b, int[] p) {
    	a = find(a, p);
    	b = find(b, p);
    	if(a == b) return;
    	
    	p[b] = a;
    }
}