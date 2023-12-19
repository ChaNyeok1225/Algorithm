//start	2023. 12. 19  12 : 54
//end 	2023. 12. 19  13 : 
import java.io.*;
import java.util.*;

public class Main {
	
	static int[] nums;
	static long[][] dp;
	static int n;
	
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        
        dp = new long[21][n];
        nums = new int[n];
        
//        for(int i = 0; i < 21; i++)
//        	Arrays.fill(dp[i], 1);
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
        	nums[i] = Integer.parseInt(st.nextToken());
        }
        
        long ans = memo(1, nums[0]);
        
        System.out.println(ans);
    }
    
    static long memo(int cnt, int value) {
    	if(dp[value][cnt] != 0)
    		return dp[value][cnt];
    	
    	if(cnt == n - 1) {
    		if(value == nums[n-1])
    			return dp[value][cnt] = 1;
    		return 0;
    	}
    	dp[value][cnt] = 0;
    	if(value - nums[cnt] >= 0)
    		dp[value][cnt] += memo(cnt+1, value - nums[cnt]);
    	if(value + nums[cnt] <= 20)
    		dp[value][cnt] += memo(cnt+1, value + nums[cnt]);
    	return dp[value][cnt];
    }
}