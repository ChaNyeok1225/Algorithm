import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        int len = targets.length;
        
        Arrays.sort(targets, (a,b) -> {
           if(a[1] == b[1])
               return a[0] - b[0];
            return a[1] - b[1];
        });
        
        // for(int i = 0; i < len; i++)
            // System.out.println(Arrays.toString(targets[i]));
        
        int piv = 0;
        for(int i = 0; i < len; i++) {
            int[] target = targets[i];
            
            if(target[0] >= piv) {
                piv = target[1];
                answer++;
            }
        }
        
        return answer;
    }
}