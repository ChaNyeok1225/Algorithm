import java.io.*;
import java.util.*;

// start = 2023. 12. 15  12 : 01
// end = 
public class Main {
	
	static int n, ans, stat[][], selA[], selB[];
	
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        stat = new int[n][n];
        selA = new int[n];
        selB = new int[n];
        ans = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < n; j++) {
        		stat[i][j] = Integer.parseInt(st.nextToken());
        	}
        }
        
        subs(0, 0, 0, 0, 0);
        
        System.out.println(ans);
    }
    
    static void subs(int cnt, int cntA, int cntB, int sumA, int sumB) {
    	
    	if(cnt == n) {
    		if(cntA == 0 || cntB == 0)
    			return;
    		
    		int val = Math.abs(sumA - sumB);
    		ans = ans < val ? ans : val; 
    		return;
    	}
    	
    	int sum = 0;
    	for(int i = 0; i < cntA; i++) {
    		sum += stat[selA[i]][cnt] + stat[cnt][selA[i]];
    	}
    	selA[cntA] = cnt;
    	subs(cnt+1, cntA+1, cntB, sumA + sum, sumB);
    	
    	sum = 0;
    	for(int i = 0; i < cntB; i++) {
    		sum += stat[selB[i]][cnt] + stat[cnt][selB[i]];
    	}
    	selB[cntB] = cnt;
    	subs(cnt+1, cntA, cntB+1, sumA, sumB + sum);
    	
    	
    }
    
}