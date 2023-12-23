import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int didx = n - 1;
        int pidx = n - 1;
        
        
        while(true) {
            if(didx == -1 && pidx == -1)
                break;
            
            int bring = cap;
            int pick = 0;
            int b = -1;
            int p = -1;
            
            while(bring > 0 && didx != -1) {
                if(deliveries[didx] > 0) {
                    b = b > didx ? b : didx;
                    deliveries[didx]--;
                    bring--;
                } else
                    didx--;
            }
            
            while(pick < cap && pidx != -1) {
                if(pickups[pidx] > 0) {
                    p = p > pidx ? p : pidx;
                    pick++;
                    pickups[pidx]--;
                } else
                    pidx--;
            }
            // System.out.println((b+1) +", " + (p+1));
            answer += Math.max(b+1,p+1) * 2;
        }
        
        
        return answer;
    }
}