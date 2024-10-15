import java.util.*;
import java.util.HashMap.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        int len = rocks.length;
        Arrays.sort(rocks);
    
        int l, r, mid, prev, cnt;
        
        l = 0;
        r = distance;
        while(l <= r) {
            mid = (l + r) / 2;
            cnt = 0;
            prev = 0;
            
            for(int i = 0; i < len; i++) {
                if(rocks[i] - prev < mid) {
                    cnt++;
                } else {
                    prev = rocks[i];
                }
            }
            
            if(distance - prev < mid) {
                cnt++;
            }
            
            if(cnt > n) {
                r = mid - 1;
            } else {
                answer = mid;
                l = mid + 1;
            }
                
        }
        
        
        return answer;
    }
}