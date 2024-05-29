import java.util.*;

class Solution {
    
    public int solution(int[][] scores) {
        int answer = 1;
        
        int len = scores.length;
        int[] target = scores[0];
        int targetScore = target[0] + target[1];
        
        Arrays.sort(scores, (a,b) -> {
                if(a[0] == b[0])
                    return a[1] - b[1];
                return b[0] - a[0];
        });
        
        int prevMax = 0, sum;
        for(int[] score : scores) {
            sum = score[0] + score[1];
            
            if(target[0] < score[0] && target[1] < score[1])
                return -1;
            
            if(prevMax > score[1])
                continue;
            
            if(targetScore < sum)
                answer++;
            
            prevMax = prevMax > score[1] ? prevMax : score[1];
        }
        
        
        return answer;
    }
}