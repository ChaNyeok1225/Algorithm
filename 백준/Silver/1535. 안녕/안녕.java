//start	2023. 12. 21  15 : 52
//end 	2023. 12. 21  16 : 12
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[101][n+1];
        
        int[] hp = new int[n+1];
        int[] happy = new int[n+1];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < n + 1; i++)
        	hp[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < n + 1; i++)
        	happy[i] = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < 101; i++) {
        	for(int j = 1; j < n + 1; j++) {
        		dp[i][j] = dp[i][j-1];
        		if(i <= hp[j]) continue;
        		if(dp[i][j] < dp[i-hp[j]][j-1] + happy[j])
        			dp[i][j] = dp[i-hp[j]][j-1] + happy[j];
        	}
        }
        
        System.out.println(dp[100][n]);
        
    }
}