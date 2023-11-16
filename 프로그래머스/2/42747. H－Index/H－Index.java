import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int len = citations.length;
        
        Arrays.sort(citations);
        
        for(int i = len-1; i >= 0; i--) {
            if(citations[i] > answer)
                answer++;
            else
                break;
        }
        
        return answer;
    }
}