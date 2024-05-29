import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int len = tangerine.length;
        
        Arrays.sort(tangerine);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        
        int cnt = 0;
        int prev = tangerine[0];
        for(int i = 0; i < len; i++) {
            if(prev == tangerine[i])
                cnt++;
            else {
                pq.offer(cnt);
                prev = tangerine[i];
                cnt = 1;
            } 
        }
        pq.offer(cnt);
        
        int sum = 0;
        while(sum < k)  {
            sum += pq.poll();
            answer++;
        }
        
        return answer;
    }
}