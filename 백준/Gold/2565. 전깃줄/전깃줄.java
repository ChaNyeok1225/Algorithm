import java.io.*;
import java.util.*;

//start	2023. 12. 15  15 : 12
//end	2023. 12. 15  
public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        
        List<int[]> line = new ArrayList<int[]>();
        
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	
        	line.add(new int[] {from, to});
        }
        
        line.sort((a,b) -> a[0] - b[0]);
        
        int[] dp = new int[line.size()];
        Arrays.fill(dp, 1);
        
        for(int i = 1; i < dp.length; i++) {
        	for(int j = 0; j < i; j++) {
        		if(line.get(i)[1] > line.get(j)[1])
        			dp[i] = dp[i] > dp[j] + 1? dp[i] : dp[j] + 1;
        	}
        }
        
        int max = 0;
        for(int i = 0; i < dp.length; i++)
        	max = max > dp[i] ? max : dp[i];
        	
        System.out.println(n - max);

    }
}