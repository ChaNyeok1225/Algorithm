import java.util.*;

class Solution {
    
    public int solution(int[][] scores) {
        int n = scores.length;
        
        int[] wonho = {scores[0][0], scores[0][1]};
        
        int MAX_VAL = 100_005;
        int[] acc = new int[MAX_VAL];
        
        for(int i = 0; i < n; i++) {
            acc[scores[i][0]] = Math.max(acc[scores[i][0]], scores[i][1]);
        }
        for(int i = MAX_VAL - 2; i >= 0; i--) {
            acc[i] = Math.max(acc[i], acc[i+1]);
        }
        
        Arrays.sort(scores, (a,b) -> {
            return -Integer.compare(a[0]+a[1], b[0]+b[1]);
        });
        
        int grade = 0;
        int cnt = 0;
        int prev = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            if(scores[i][1] < acc[scores[i][0] + 1])
                continue;
            cnt++;
            
            if(prev > scores[i][0] + scores[i][1]) {
                grade += cnt;
                cnt = 0;
                prev = scores[i][0] + scores[i][1];
            }
            if(wonho[0] == scores[i][0] && wonho[1] == scores[i][1])
                return grade;
        }
        
        return -1;
    }
}