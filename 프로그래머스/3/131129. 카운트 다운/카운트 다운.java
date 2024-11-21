// DP 풀이

import java.util.*;

class Solution {
    public int[] solution(int target) {
        int[][] dp = new int[target+100][2];
        int num;
        for(int i = 0; i < target; i++) {
            
            num = i + 50;
            if(dp[num][0] == 0 || dp[num][0] > dp[i][0] + 1) {
                dp[num][0] = dp[i][0] + 1;
                dp[num][1] = dp[i][1] + 1;
            } else if(dp[num][0] == dp[i][0] + 1){
                dp[num][1] = Math.max(dp[num][1], dp[i][1] + 1);
            }
            
            for(int m = 1; m < 4; m++) {
                for(int s = 1; s < 21; s++) {
                    num = i + m * s;
                    
                    if(dp[num][0] == 0 || dp[num][0] > dp[i][0] + 1) {
                        dp[num][0] = dp[i][0] + 1;
                        dp[num][1] = dp[i][1] + (m == 1 ? 1 : 0);
                    } else if(dp[num][0] == dp[i][0] + 1){
                        dp[num][1] = Math.max(dp[num][1], dp[i][1] + (m == 1 ? 1 : 0));
                    }
                }
            }
        }
        
        return new int[] {dp[target][0], dp[target][1]};
    }
}