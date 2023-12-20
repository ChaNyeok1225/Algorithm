//start	2023. 12. 20  13 : 29
//end 	2023. 12. 20  13 : 47
import java.io.*;
import java.util.*;

public class Main {
	
	static int[] p;
	
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[] cost = new int[n];
        p = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
        	cost[i] = Integer.parseInt(st.nextToken());
        	p[i] = i;
        }
        
        for(int i = 0; i < m; i++) {
        	st= new StringTokenizer(br.readLine());
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	
        	union(from-1, to-1);
        }
        
        int[] minCost = new int[n+1];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        
        for(int i = 0; i < n; i++) {
        	int idx = find(i);
        	minCost[idx] = minCost[idx] < cost[i] ? minCost[idx] : cost[i];
        }
        
        int ans = 0;
        for(int i = 0; i < n; i++) {
        	if(minCost[i] != Integer.MAX_VALUE)
        		ans += minCost[i];
        }
        if(k < ans)
        	System.out.println("Oh no");
        else
        	System.out.println(ans);
        
        
    }
    
    static int find(int a) {
    	if(p[a] == a) return a;
    	return p[a] = find(p[a]);
    }
    
    static void union(int a, int b) {
    	a = find(a);
    	b = find(b);
    	
    	if(a != b)
    		p[b] = a;
    }
    
    
}