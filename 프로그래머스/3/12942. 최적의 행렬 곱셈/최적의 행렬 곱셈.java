import java.util.*;

class Solution {
    public int solution(int[][] matrix_sizes) {
        int answer = 0;
        int len = matrix_sizes.length;
        
        int[][] dp = new int[len][len];
        
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len - i; j++) {
                int s = j;
                int e = j + i;
                
                if(s==e) {
                    dp[s][e] = 0;
                } else {
                    dp[s][e] = Integer.MAX_VALUE;
                    
                    for(int k = s; k < e; k++) {
                        dp[s][e] = Math.min(dp[s][e], dp[s][k] + dp[k+1][e] + (matrix_sizes[s][0] * matrix_sizes[k][1] * matrix_sizes[e][1]));
                    }
                }
            }
        }
        
        // for(int i = 0; i < len; i++) 
        //     System.out.println(Arrays.toString(dp[i]));
        
        
        return dp[0][len-1];
    }
}