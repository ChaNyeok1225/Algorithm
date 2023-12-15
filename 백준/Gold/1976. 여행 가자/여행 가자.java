import java.io.*;
import java.util.*;

//start	2023. 12. 15  13 : 45
//end	2023. 12. 15 
public class Main {
	
	static int p[];
	
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        p = new int[n];
        for(int i = 0; i < n; i++)
        	p[i] = i;
        
        int[][] graph = new int[n][n];
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < n; j++) {
        		graph[i][j] = Integer.parseInt(st.nextToken());
        		
        		if(graph[i][j] == 1)
        			union(i, j);
        	}
        }
        
        st = new StringTokenizer(br.readLine());
        String ans = "YES";
        
        int val = find(Integer.parseInt(st.nextToken()) - 1);
        
        for(int i = 1;  i < m; i++) {
        	if(val != find(Integer.parseInt(st.nextToken()) - 1)) {
        		ans = "NO";
        		break;
        	}
        }
        
        System.out.println(ans);
    }
    
    static int find(int a) {
    	if(p[a] == a) return a;
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