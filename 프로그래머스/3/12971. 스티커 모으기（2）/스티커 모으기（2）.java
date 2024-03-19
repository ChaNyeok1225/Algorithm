import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        int answer = 0;

        int len = sticker.length;
        if(len == 1) {
            return sticker[0];
        }
        
        int[] dp = new int[len+3];
        
        dp[0] = sticker[0];
        dp[1] = Math.max(dp[0], sticker[1]);
        for(int i = 2; i < len - 1; i ++) {
            dp[i] = Math.max(dp[i-1], sticker[i] + dp[i-2]);
        }
        
        answer = dp[len-2];
        dp[0] = 0;
        dp[1] = sticker[1];
        for(int i = 2; i < len; i ++) {
            dp[i] = Math.max(dp[i-1], sticker[i] + dp[i-2]);
        }
        
        answer = Math.max(answer, dp[len-1]);
        
        return answer;
    }
}