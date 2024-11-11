import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int n = diffs.length;
        int r = 0, l = 1, mid, tmp;
        for(int i = 0; i < n; i++) 
            r = r > diffs[i] ? r : diffs[i];
        
        long total;
        while(l <= r) {
            mid = (l + r) / 2;
            
            total = 0;
            for(int i = 0; i < n; i++) {
                total += times[i];
                if(mid < diffs[i]) {
                    total += (long)(diffs[i] - mid) * (times[i] + times[i-1]); 
                }
                if(total > limit) 
                    break;
            }
            
            if(total > limit) {
                l = mid + 1;
            } else {
                r = mid - 1;
                answer = mid;
            }
        }
        
        return answer;
    }
}