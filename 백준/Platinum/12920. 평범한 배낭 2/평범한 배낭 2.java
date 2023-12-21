import java.io.*;
import java.util.*;

//start	2023. 12. 20  16 : 42
//end 	2023. 12. 20  16 : 56
public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] use = new int[m+1][n+1];
        int[] dp = new int[m+1];
        
        int[][] obj = new int[n+1][3];
        for(int i = 1; i < n + 1; i++) {
        	st = new StringTokenizer(br.readLine());
        	obj[i][0] = Integer.parseInt(st.nextToken());
        	obj[i][1] = Integer.parseInt(st.nextToken());
        	obj[i][2] = Integer.parseInt(st.nextToken());
        }
        
        for(int i = 1; i < m + 1; i++) {
        	int max = dp[i] = dp[i-1];
        	int selidx = -1;
        	
        	dp[i] = dp[i-1];       	
        	
        	for(int j = 1; j < n + 1; j++) {
        		if(i < obj[j][0]) continue;
        		
        		if(max < dp[i-obj[j][0]] + obj[j][1] && use[i-obj[j][0]][j] < obj[j][2]) {
        			max = dp[i-obj[j][0]] + obj[j][1];
        			selidx = j;
        		}
        	}
 
        	if(selidx == -1) {
        		for(int j = 0; j < n + 1; j++)
            		use[i][j] = use[i-1][j];
        	} else {
        		for(int j = 1; j < n + 1; j++) 
        			use[i][j] = use[i - obj[selidx][0]][j];
        		use[i][selidx]++;
        		dp[i] = max;
        	}
        	
        }
        
        System.out.println(dp[m]);
    }
}