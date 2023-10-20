import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
    
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for(int i = 0; i < scoville.length; i++)
            q.offer(scoville[i]);
        
        int answer = 0;
        while(q.size() > 1 && q.peek() < K) {
            answer++;
            int a = q.poll();
            int b = q.poll();
            q.offer(a + b*2);
        }
        
        if(q.peek() < K)
            answer = -1;
        
        return answer;
    }
}